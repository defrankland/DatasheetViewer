package com.datasheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.datasheet.model.Datasheet;
import com.datasheet.service.DatasheetService;


@Controller
@RequestMapping("/load")
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class DatasheetController {

	@Autowired
	DatasheetService datasheetSvc;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getDatasheets(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
		model.addAttribute("datasheet", datasheetSvc.getAllDatasheets(username));
		return "load.jspx";
	}
	
	@RequestMapping(params = "add", method=RequestMethod.POST)
	public String addDatasheet(Model model,
							 @RequestParam("dsName") String name,
							 @RequestParam("dsLink") String location,
							 @RequestParam("dsDescription") String description){


		Datasheet ds = new Datasheet();
		ds.setName(name);
		ds.setLocation(location);
		ds.setDescription(description);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
		datasheetSvc.saveDatasheet(ds, username);
		
		model.addAttribute("datasheet", datasheetSvc.getAllDatasheets(username));
		return "load.jspx";
	}
	
	@RequestMapping(params = "remove", method=RequestMethod.POST)
	public String removeDatasheet(Model model,
			 					  @RequestParam("dsName") String name){

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
		datasheetSvc.removeDatasheetByName(name, username);
		
		model.addAttribute("datasheet", datasheetSvc.getAllDatasheets(username));
		return "load.jspx";
	}
	
}

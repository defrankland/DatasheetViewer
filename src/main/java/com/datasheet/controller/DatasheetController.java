package com.datasheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.datasheet.model.Datasheet;
import com.datasheet.service.DatasheetService;


@Controller
@RequestMapping("/load")
public class DatasheetController {

	@Autowired
	DatasheetService datasheetSvc;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getDatasheets(Model model){
		model.addAttribute("datasheet", datasheetSvc.getAllDatasheets());
		return "load";
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
		
		datasheetSvc.saveDatasheet(ds);
		
		model.addAttribute("datasheet", datasheetSvc.getAllDatasheets());
		return "load";
	}
	
	@RequestMapping(params = "remove", method=RequestMethod.POST)
	public String removeDatasheet(Model model,
			 					  @RequestParam("dsName") String name){

		datasheetSvc.removeDatasheetByName(name);
		
		model.addAttribute("datasheet", datasheetSvc.getAllDatasheets());
		return "load";
	}
}

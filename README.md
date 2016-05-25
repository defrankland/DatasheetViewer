# DatasheetViewer

This project allows datasheets to be added to a NoSQL database and viewed in a web browser. It is intended to be used for collecting datasheets while researching electronic components.

Uses:

-eclipse Mars.2

-gradle

-jetty

-MongoDB

-Embedded SQL 

-Spring Framework


The setup is current configured to run on localhost. The view can be accessed by browsing:

    http://localhost:7777/DatasheetViewer/

Requires a local instance of MongoDB (see datasheetviewer-context.xml for database configuration)

New users can be created at runtime but will only last during runtime.


### students-backend

A Spring Boot and Apache Camel based applications which is able to parse a several csv files from a 
directory and inserts their data into a MySQL database.
This service is used set up all needed data for a school year. It inserts into the database all required fields to start school.

The database connection is configured using the ```application.properties``` file.

Configure the source directory using the ```routeUri.sourceDirectory``` property ans the fileName using the 
```routeuri.fileName``` property.


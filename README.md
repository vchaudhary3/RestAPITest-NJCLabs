# RestAPITest-NJCLabs

This repo uses pets.sql as the database for all its manipulations. 

## SQL Retrieval Commands
This file contains different types of SQL querries you can run on the database provided.

## JavaMysqlSelect
This runs the sql querries through a java code and records the answers into a arraylist that can be used. to run this file first compile the code and set the classpath variable to a java connection driver which should be in the same folder as the code. 

## SqlRest
This is the REST API. I have used the javax.servlet package and overrided the doGet() for GET requests to customize the retrievel commands that would work for this database. To run this code you must need apache tomcat and must set your classpath variable to the servlet.jar driver. 


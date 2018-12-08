# Printing Service

This is a maven project that reads printing jobs from a CSV file and output its detailed cost. 
The application is built with maven and run with java 8.

### Prerequisites
You need to have the following tools installed:
- Maven
- Java 8 or later

### How to Run it
Follow this part if you are only interested in running the application

Go to the project directory
```
cd printingService/
```
 
Then move to the target directory
```
cd target/
``` 

Run printingService-jar-with-dependencies.jar passing a CSV file as argument. In this example a project example file is passed
```
java -jar printingService-jar-with-dependencies.jar ../src/main/resources/jobs.csv
``` 

The print jobs cost will be printed on console. The following output results from the previous line.
```
 Total Pages = 25 - Color Pages = 10 - Double = false - Cost = $4.75
 Total Pages = 55 - Color Pages = 13 - Double = true - Cost = $6.80
 Total Pages = 502 - Color Pages = 22 - Double = true - Cost = $52.40
 Total Pages = 1 - Color Pages = 0 - Double = false - Cost = $0.15
 
 Number of Jobs =  4
 Total Cost = $64.10
``` 

### Full installation
Follow this part if you are interested in running tests and changing the code. If you want to get a new jar file because you changed the code or wanna run test cases you should execute the following lines:

Go to the project directory
```
cd printingService/
```

You will find a pom.xml (this is the file that tells maven how to build the project). Run the following and tests will execute followed by the creation of target folder where lies the new jar file
```
mvn clean test compile assembly:single
``` 

Go to the target directory
```
cd target/
``` 

Run printingService-jar-with-dependencies.jar passing a CSV file as argument. In this example a project example file is passed
```
java -jar printingService-jar-with-dependencies.jar ../src/main/resources/jobs.csv
``` 

The print jobs cost will be printed on console. The following output results from the previous line.
```
 Total Pages = 25 - Color Pages = 10 - Double = false - Cost = $4.75
 Total Pages = 55 - Color Pages = 13 - Double = true - Cost = $6.80
 Total Pages = 502 - Color Pages = 22 - Double = true - Cost = $52.40
 Total Pages = 1 - Color Pages = 0 - Double = false - Cost = $0.15
 
 Number of Jobs =  4
 Total Cost = $64.10
``` 

### Run only tests
Go to the project directory
```
cd printingService/
```

You will find a pom.xml (this is the file that tells maven how to build the project). Run the following and tests will execute:
```
mvn clean test
``` 

### Project structure

* docs: 
    - instructions to run, configure, deploy.
    - technical aspects about the code.
    - some UML class diagrams for a general understanding.

* src:
    there are two directories
    - main: here you can find the code.
    - test: here are the 13 test cases. 
    
* target: 
    - this folder contains the executable application, printingService-jar-with-dependencies.jar.
    - this folder can be recompiled an generated many times, instructions are in docs/instructions.md.
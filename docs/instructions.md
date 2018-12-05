#appication syntax
java -jar printingService-jar-with-dependencies.jar FILE_WITH_JOBS.csv

You only need to have Java 8 installed, printingService-jar-with-dependencies.jar file and the CSV file you want to process.

#regenerate target directory
Here are created the executable file from the code. For this you need to be in the project directory and run on the console:

mvn clean test compile assembly:single

#run example

- example file src/main/resources/jobs.csv:

Total Pages, Color Pages, Double Sided
25, 10, false
55, 13, true
502, 22, true
1, 0, false

- unzip project

- open target directory:
 cd target
 
- and run on console (in this example we process the example jobs.csv file):

java -jar printingService-jar-with-dependencies.jar ../src/main/resources/jobs.csv

- the output will be for this example:

 Total Pages = 25 - Color Pages = 10 - Double = false - Cost = $4.75
 Total Pages = 55 - Color Pages = 13 - Double = true - Cost = $6.80
 Total Pages = 502 - Color Pages = 22 - Double = true - Cost = $52.40
 Total Pages = 1 - Color Pages = 0 - Double = false - Cost = $0.15
 
 Number of Jobs =  4
 Total Cost = $64.10

#compile and run tests
- go to project folder where pom.xml is and run: 

mvn clean test compile assembly:single

- you will see 13 test run on console.

- change to target directory where you will find the jar file which runs the application. Its name is: printingService-jar-with-dependencies.jar 
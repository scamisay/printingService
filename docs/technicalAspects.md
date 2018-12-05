#Tests
- 13 test cases with JUnit 4 have been done and passed. 
- These tests cover the essential of the application. They focus on domain, services and helper objects.

#Design
The three more important domain objects are:
* PaperType: Contains variables needed to calculate the cost of a printing based on variables like double/single sided printing, paper type and color/black and white.
* Job: This object collects the information read from each line of the CSV file.
* JobCost: This contains a Job and its cost.
 
There are no hardcode values. Parameters like defaultPaperType and paperSettingFile are read from application.properties. The CSV file name and path are obtained as an application parameter from the console.
Paper settings are read form a yaml file included in the project. Its name is papers.yaml:
* is located in src/main/resources/papers.yaml
* its content:
papers:
```yaml
 - type: A4
   singleSided:
    blackAndWhite: 15
    color: 25
   doubleSided:
     blackAndWhite: 10
     color: 20
 ```
 Each '-' is an item of configuration. In this case we have the settings for A4 paper type. Then we have a division between singleSided and doubleSided where costs are expressed for colors and black and white printings.
 In an item configuration costs are set for the four possible cases of a paper type.

The CSV reading is bufferized in order to make RAM consumption as eficient as possible.

Job objects has a parser engine in its constructor. It receives a line from the CSV file and turn it into a printing job information for latter processing.

#Error handling
Emerging errors are printed on the console.
Exceptions are catched and treated.
Possible errors are: bad arguments at running the application or an invalid CSV file.
The parser will find and show problematics line so the user can correct them and process the edited file over.

#future developments
It would take a litle more of develpment to add different papers types to process. It would be needed to sum a paper type column in CSV, add an entry in yaml file and modify ther parser.
# Group gr2362 repository 
# Padel App

# Running in Eclipse che
[<img src="https://eclipse.dev/che/docs/_/img/icon-eclipse-che.svg" width = "25"/> Open in Eclipse Che](https://che.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2362/gr2362?new)

# About the PadelApp:
The Padel App is an app that organize matches and tournaments, and creates a scoreboard and leaderboard for the results.

The app is located in: PadelApp/ui/src/main/java/PadelApp/ui/App.java

# Project setup and build
The project uses Maven as a building tool.

Necessary java-version: java 17.0.8-tem

Necessary maven-version: maven 3.9.4

## Running the app
To run the app you have to run the restserver first.

To initialize the restserver run: `mvn clean install -f ./springboot/restserver/pom.xml´
To run the restserver from root, run: `mvn spring-boot:run -f ./springboot/restserver/pom.xml´
Open new terminal, and run: `mvn javafx:run -f ./ui/pom.xml´

## Testing
To test the core module from root, run: `mvn test -f ./core/pom.xml´
To test the ui module from root, run:
* `mvn spring-boot:run -f ./springboot/restserver/pom.xml´
* Open new terminal and run: `mvn test -f ./ui/pom.xml`
To test the springboot restserver / API froom root, run: `mvn test -f ./springboot/restserver/pom.xml´


# Code quality tools
We use three code quality analysis tools to make sure our code is up to standards:

* JaCoCo: to check our tests' code coverage
* SpotBug: to spot bugs
* Checkstyle: generates a report regarding the code style

All three generate HTML reports with pointers to what can be improved.

To generate the checkstyle report from root, run: `mvn checkstyle:checkstyle´
The report can be found in each modules /target/site folder
You can also run the checkstyle test without creating a report by running: `mvn checkstyle:check´

To generate the spotbugs report from root, run : `mvn spotbugs:spotbugs´
The report can be found in each modules /target folder
You can also run the spotbugs test without creating a report by running: `mvn spotbugs:check´

To generate JaCoCo test coverage report, run the maven tests as described in the testing section above.
The report can be found in each modules /target/site/jacoco folder

You can open the reports by copying the path and paste into a web browser. 

# Diagram
You can see our diagrams below:

Package diagram:
[here](/PadelApp/pictures/PackageDiagram.png)

Class diagram:
[here](/PadelApp/pictures/classDiagram.png)

Sequence diagram:
[here](/PadelApp/pictures/sequenceDiagram.png)



# The Code Structure
* **PadelApp/.idea**:
* **PadelApp/.vscode**: (settings.json)
* **docs**: the release documents (release1, release 2, release 3)
* **PadelApp/core/src/main/java/PadelApp/core**: domain logic
* **PadelApp/core/src/main/java/PadelApp/json**: filehandling
* **PadelApp/core/src/test/java/PadelApp/core**: tests for domain logic
* **PadelApp/core/src/test/java/PadelApp/json**: tests for filehandling
* **PadelApp/pictures**: pictures of the app and diagrams
* **PadelApp/plantUMLdiagrams**: the plantuml diagrams (classDiagram.puml, PackageDiagram.puml, sequenceDiagram.puml)
* **PadelApp/springboot/restserver/src/main/java/PadelApp/springboot/restserver**: the restserver files
* **PadelApp/springboot/restserver/src/test/java/PadelApp/springboot/restserver**: the tests for restserver
* **PadelApp/ui/src/main/java/PadelApp/ui**: App and controllers
* **PadelApp/ui/src/main/resources**: fxml files
* **PadelApp/ui/src/test/java/PadelApp/ui**: controller tests
 




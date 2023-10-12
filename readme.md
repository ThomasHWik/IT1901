# Group gr2362 repository 
# Padel App

# Running in Eclipse che
[<img src="https://eclipse.dev/che/docs/_/img/icon-eclipse-che.svg" width = "25"/> Open in Eclipse Che](https://che.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2362/gr2362?new)

# About the PadelApp:
The Padel App is an app that is supposed to organize matches and tournaments, and creates a scoreboard for the results.

The app is located in PadelApp

# Project setup and build
The project uses Maven as a building tool.

Necessary java-version: java 17.0.8-tem

Necessary maven-version: maven 3.9.4

To build, run: `mvn install`

You can run the app using: `mvn javafx:run`

You can run the test using: `mvn test`

# Code quality tools
We use three code quality analysis tools to make sure our code is up to standards:

* JaCoCo: to check our tests' code coverage
* SpotBug: to spot bugs
* Checkstyle: generates a report regarding the code style

All three generate HTML reports with pointers to what can be improved.

# Diagram
You can see our package diagram below:

[here](/PackageDiagram.png)


# The Code Structure
* **docs**: the release documents (release1, release 2)
* **PadelApp/.idea**:
* **PadelApp/.vscode**: (launc.json, settings.json)
* **PadelApp/core/src/main/java/core**: domain logic and filehandling
* **PadelApp/core/src/test**: tests for domain logic
* **PadelApp/ui/src/main/java/ui**: App and controllers
* **PadelApp/ui/src/main/resources**: fxml files
* **PadelApp/ui/src/test**: App and controller test
 




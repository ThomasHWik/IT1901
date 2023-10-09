# Group gr2362 repository 
 
# Padel App

[<img src="https://eclipse.dev/che/docs/_/img/icon-eclipse-che.svg" width = "25"/> Open in Eclipse Che](https://che.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2023/gr2362/gr2362?new)

The Padel App is an app that is supposed to organize matches and tournaments, and creates a scoreboard for the results.

# Project setup and build
The project uses Maven as a building tool.

Necessary java-version: java 17.0.8-tem

Necessary maven-version: maven 3.9.4

To build, run: `mvn install`

You can run the app using: `mvn javafx:run`

You can run the test using: `mvn test`

# The Code Structure
* **.idea**: 
* **.vscode**:
* **docs**: the release documents (release1, release 2)
* **PadelApp/.idea**:
* **PadelApp/.vscode**: (launc.json, settings.json)
* **PadelApp/src/main/java/app**: App.java, App-controllers
* **PadelApp/src/main/java/FileManaging**: Filehandling
* **PadelApp/src/main/java/Logic**: Domain logic
* **PadelApp/src/main/resources**: fxml files
* **PadelApp/src/test/ControllerTest**: AppTest
* **PadelApp/src/test/LogicTest**: PadelTest
* **PadelApp/target**: 



# springboot module

The springboot module contains the Restserver and the REST-API for the Padel App. It includes functionality to manage the Padel leaderboard and scoreboard.



## Classes

* **springboot/restserver/PadelModelApplication:** application class that configures and launches the spring boot application
* **springboot/restserver/PadelModelController:** controller class handling HTTP requests related to the Padel leaderboard and scoreboard
* **springboot/restserver/PadelModelService:** This class provides methods to manage the PadelModelService, which is responsible for managing the Leaderboard and Scoreboard data. The class provides methods to save, get and add to the Leaderboard, as well as initialize the Leaderboard. The Leaderboard is saved as a JSON file using the FileManagerJson class.

## Build and run

To initialize the restserver run: mvn clean install -f ./springboot/restserver/pom.xml
To run the restserver from PadelApp, run: mvn spring-boot:run -f ./springboot/restserver/pom.xml
Open new terminal, from ui run mvn javafx:run





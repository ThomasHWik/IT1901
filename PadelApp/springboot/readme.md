# springboot module

The springboot module contains the Restserver and the REST-API for the Padel App. It includes functionality to manage the Padel leaderboard.

## REST-API implementation

The restserver utilizes a simple springboot application with a controller for api endpoints and service that processes api requests.
It includes endpoints for sending a scoreboard to the server, retrieving the leaderboard from the server and initializing the server. No special configuration of the springboot server has been done and it utilizes the default 8080 port. for its endpoints.


## Usage

### Endpoints

#### Base Endpoint

* URI: host:port/api/padel  
<http://localhost:8080/api/padel>
* Response: 
    * None

#### Get Leaderboard
Retrieves the Padel leaderboard stored on the server.
* Endpoint: GET /api/padel/leaderboard 
<http://localhost:8080/api/padel/leaderboard>
* Response:
    * 200 OK with the leaderboard if it exists.
    * 404 Not Found if the leaderboard does not exist.


#### Add Scoreboard
Adds scoreboard from client to the server leaderboard
* Endpoint: POST /api/padel/addScoreboard  
<http://localhost:8080/api/padel/addScoreboard>
* Request:
    * Method: POST
    * URL: /api/padel/addScoreboard
    * Body: JSON object representing the scoreboard.
* Response:
    * 200 OK with a success message if the scoreboard is processed successfully.
    * 400 Internal Server Error with an error message if an error occurs.

#### Initialize
Initializes the restServer with a Leaderboard when its known that the server doesnt have an existing Leaderboard file.
* Endpoint: GET /api/padel/initialize  
<http://localhost:8080/api/padel/initialize>
* Response:  
    * 200 OK with sucess message

## Classes

* **springboot/restserver/PadelModelApplication:** application class that configures and launches the spring boot application
* **springboot/restserver/PadelModelController:** controller class handling HTTP requests related to the Padel leaderboard and scoreboard
* **springboot/restserver/PadelModelService:** This class provides methods to manage the PadelModelService, which is responsible for managing the Leaderboard and Scoreboard data. The class provides methods to save, get and add to the Leaderboard, as well as initialize the Leaderboard. The Leaderboard is saved as a JSON file using the FileManagerJson class.

## Build and run

To initialize the restserver run: mvn clean install -f ./springboot/restserver/pom.xml
To run the restserver from PadelApp, run: mvn spring-boot:run -f ./springboot/restserver/pom.xml
Open new terminal, from ui run mvn javafx:run





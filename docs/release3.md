# Release 3

## What's new

### New functionality

For the third and last release we have extended with new and more functionality.

These classes are new:
* **core/gameSetup.java**
* **core/RoundSelector.java**

On the first page in the app we have added a choice for the user so the user can choose how many rounds they want to play, instead of the rounds being 5 each time as it was in release 2. We have also added a choice for how many double courts they want to play on where they can choose between 0-2.

For the functionality on the second page in the app, we have made single and double courses. We have added a choice so that the player can choose if they want zero, one or two double courts and the rest are divided in single courts. We have also changed that after each round of the game, the players change who they play against.

We have also done some changes on the last page in the app. In release 2 you could only see a leaderboard, but now we have created a scoreboard so you can see both scoreboard and leaderboard on the last page. The scoreboard shows the ranking of players in one game of selected rounds, while leaderboard shows the ranking of all players that have played ever.

### REST-API
For this release we have implemented a springboot server as our REST-API. It runs on default port 8080 and completes PadelApp functionality of having a "global" leaderboard that current games gets added to.

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


These classes are new:
* **core/RemoteLeaderboardAccess.java**
* **restserver/PadelModelApplication.java**
* **restserver/PadelModelController.java**
* **restserver/PadelModelService.java**

To initialize the restserver run: mvn clean install -f ./springboot/restserver/pom.xml
To run the restserver from PadelApp, run: mvn spring-boot:run -f ./springboot/restserver/pom.xml
Open new terminal, from ui run mvn javafx:run

### Shippable product
To turn the app into a shippable product, the project uses jlink and jpackage.
Jlink and jpackage requires the .NET framework and wix tool set.
First run the command: `mvn javafx:jlink -f ./ui/pom.xml´ from the PadelApp folder
Then run the command: `mvn jpackage:jpackage -f ./ui/pom.xml
The installation file can then be found under the /ui/target/dist folder

### Documentation
For each module we have made readme files, so it is now one readme file in the core module; [here](/PadelApp/core/readme.md), one in the springboot module; [here](/fyll inn readmefil), and one in the ui module; [here](/PadelApp/ui/readme.md), in addition to the readme files we had before, under PadelApp and on root level which have been updated after the changes in this release.

We have updated the package diagram from last release to include the Springboot server. We have also created two new diagrams. One class diagram for the most important classes of the app, and one sequence diagram for an import use case, which shows the link between user interaction and what happens inside the system including REST calls.

#### Class Diagram
We have made a class diagram with the classes that we think is most relevant for the domain function in the app. We have included most of the classes in the core module, but left out the classes NumberManager.java, PlayerComparator.java, RemoteLeaderboardAccess.java and RoundSelector.java. These classes includes methods that is used in the app (description of the classes can be found in each class), but is not the most important classes for showing how the app works. We have also included the controller classes in the ui module, to show how these classes interact with the classes in the core module. We chose to leave out the springboot module in this class diagram, because the diagram is already quite large and our intention for the class diagram is to show the assosiations between the classes that handles the logic and the controllers that handles how it works in the app.

#### Sequence diagram
For the sequence diagram we have chosen to show the use case from the second page in the app, where the user register who wins each round, end the game after all the rounds and then sees the scoreboard and leaderboard. In the diagram you can see the link between user interaction, what happens inside the system, like which methods that are being called, and at the end the REST calls. We chose to not include the registration of the players because then the diagram would have been very large and unclear to understand.

#### Documentation for classes and methods
In the entire project we have added comments and javadoc-comments to give a better description of methods. This makes it easier for everyone to understand different parts of our code. We wrote javadoc-comments on every methods, even though it is most important on the largest methods, but we think it makes it easier for other people to understand our code and understand why all the methods we have included is necessary to make the app work as wanted.

## Modularization
The PadelApp is structured in a set of modules where the main logic, the ui and the springboot is seperated.

### Core module
The core folder contains the domain logic and file handling

### UI module
This folder contains the ui-related files in our project. This includes the app file, controller files and the fxml files.

### Springboot module
This folder contains the restserver files. This includes PadelModelApplication.java, PadelModelController.java and PadelModelService.java

## Work habits

### Group work
The group work has worked quite similarly to the previous release. It has consisted of both individual work and group meetings. But for this release we have been working more together to collaborate on the difficult parts such as implementation of restapi. We have also been coding two and two and documented it in commits by using "Co-authored-by:". By doing this we have been able to discuss code and how we should solve issues. To get a better overview of the requirements for this release we had one meeting with the teaching assistant. Every group member has been assigned issues and main tasks to resolve and done so.

#### Git
Similar to the previous release we have been working in branches linked to issues. In this release we have also been using tasks to increase the overview of what every group member do.

The reason for not working directly in the master branch is to make sure the master branch always have a functioning and running code and so that we dont overwrite each others work.

Each commit has a comment explaining what has been done in the code. In gitlab we have been better at ensuring that all merge requests are approved by one person reviewer before the assignee merges it. In that way it is easier to detect errors and conflicts. 

## Code quality

### Tests
We have changed and added more unit tests after adding more functionality. The unit tests make sure that the code works correctly. 

To test the core module from the PadelApp folder, run: `mvn test -f ./core/pom.xml´
To test the ui module from the PadelApp folder, run:
* `mvn spring-boot:run -f ./springboot/restserver/pom.xml´
* Open new terminal and run: `mvn test -f ./ui/pom.xml`
To test the springboot restserver from the PadelApp folder, run: `mvn test -f ./springboot/restserver/pom.xml´

### Code quality tools
We have used three code quality analysis tools to make sure our code is up to standards:

* JaCoCo: to check our tests' code coverage
* SpotBug: to spot bugs
* Checkstyle: generates a report regarding the code style

All three generate HTML reports with pointers to what can be improved.

#### Spotbugs
We have configured spotbugs to exclude certain bugs from it's report due to it detecting bugs which if fixed would not work with our app.
##### Core module
We get two types of bugs in the core module that we exclude from the report:

Bug 1: EI_EXPOSE_REP: "May expose internal representation by returning reference to mutable object"
Spotbugs complains that we return the types playerPairslist, playerList, player1 and player2, and that we may "expose
internal representation by returning" them. It also suggests that we return a copy of the object for security resons.
However, we need to return the actual objects in order to update their win score for the scoreboard and leaderboard. If
returning copies of the objects, it won't correctly update the Player objects score.

Bug 2: EI_EXPOSE_REP2: "May expose internal representation by incorporating reference to mutable object"
This bugs also complains about compromised security, due to using the playerPairslist object to create the GameSetup, and
using the player1 and player2 Player objects to create a PlayerPair object, using the "new" keyword. For the same reasons
as with bug 1, we need to use the real objects rather than copies of them as the report suggests.

##### Sringboot restserver module

In the springboot restserver module we excluded one bug from the report:

Bug 3: UUF_UNUSED_FIELD
This bug complains about a PadelModelService object not being used in the PadelModelController.java file. However it does 
get used several times, so we chose to exclude this from the report so it can't lead to any misunderstanding.

#### Checkstyle
We have configured our project to exclude certain checks from the checkstyle report such as "MultipleVariableDeclarations" and "MemberName". 

"MultipleVariableDeclarations": We have done this becuase we think the code is more readble when all the variables with the same interface/class declaration is together, as it doesn't take up as much space and you can clearly see how they are related.

"MemberName": We chose to use capital letters for court variable names as it corresponds to fxml tag names


### Test coverage

In our testing we have gotten around 80% coverage on the core and ui modules. The coverage of the core module is affected by the lack of testing of the RemoteLeadervoardAccess class due to the problems with testing the rest API as described in the challenges.md file in the root of this project.
We also prioritized testing the most likely scenarios of the methods, and delayed testing of the more rare conditions of the methods to focus on other challenges in the project.

Due to challenges described in the mentioned challenges.md we do not have comprehensive tests of the rest API



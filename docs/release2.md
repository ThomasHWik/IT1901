# Release 2

## What's new

For the second release we have added a lot of functionality to make the app work like the description we have in the readme.md file:
[here](/PadelApp/src/main/java/app/README.md)

The project is now possible to open in Eclipse Che, and the link to open it can be found in the readme.md file:
[here](/readme.md)

### Modularization
The PadelApp is structured in a set of modules where the main logic and the ui is seperated. 

#### Core module
The core folder contains the domain logic and file handling.

##### Implicit saving
We have chosen to save the elements in scoreboard implicit. 

#### UI module
This folder contains the ui-related files in our project. This includes the app file, controller files and the fxml files.


### Documentation
We have made a package diagram to documentate the architecture. The diagram have been made by using PlantUML. We chose to make a package diagram because it is a good overview of what packages we have and in which module they are located in. It also shows what dependencies there are between different packages and which library a package uses. The package diagram can be found in readme.md file or you can open it from here:
[here](/PackageDiagram.png)

The root level readme.md file have also been updated after the changes in this release.


## Work habits

### Group work
Like in the first release the group work has consisted of group meetings as well as individual work. Every group member has been assigned issues to resolve and done so. In addition, the group has met with the teaching assistant for help regarding questions we had about the second deliverable (release 2), and we have used Piazza to ask further questions.

In this release(release 2) we have been working in branches linked to issues. This helps us to avoid merge conflicts.

We have also been coding two and two and documented it in commits by using "Co-authored-by:". By doing this we have been able to discuss code and how we should solve issues.

## Code quality

### Tests
We have made unit tests to make sure that the code works correctly. This is helping us to protect the code against bugs. To run all the unit test classes, you can open the project and write the command: mvn test

### Code quality tools
We have used three code quality analysis tools to make sure our code is up to standards:

*JaCoCo: to check our tests' code coverage
*SpotBug: to spot bugs
*Checkstyle: generates a report regarding the code style

All three generate HTML reports with pointers to what can be improved.


# Release 3

## What's new

### New functionality

For the third and last release we have extended with new and more functionality.

On the first page in the app we have added a choice for the user so the user can choose how many rounds they want to play, instead of the rounds being 5 each time as it was in release 2.

For the functionality on the second page in the app, we have made single and double courses. If the players are less than 4 they are divided into single courts, and if the players are 4 or more they are divided in one double court and the rest are divided in single courts. We have also changed that after each round of the game, the players change who they play against.

We have also done some changes on the last page in the app. In release 2 you could only see a leaderboard, but now we have created a scoreboard so you can see both scoreboard and leaderboard on the last page. The scoreboard shows the ranking of players in one game of selected rounds, while leaderboard shows the ranking of all players that have played ever.

### Modularization

#### REST-API


### Documentation
We have updated the package diagram from last release to include the Springboot server. We have also created two new diagrams. One class diagram for the most important classes of the app, and one sequence diagram for an import use case, which shows the link between user interaction and what happens inside the system including REST calls.

For each module we have made readme files, so it is now one readme file in the core module; [here](/PadelApp/core/readme.md), and one in the ui module; [here](/PadelApp/ui/readme.md), in addition to the readme files we had before, under PadelApp and on root level which have been updated after the changes in this release.

In the entire project we have added comments and javadoc-comments to give a better description of methods. This makes it easier for everyone to understand different parts of our code.

## Work habits

### Group work
The group work has worked quite similarly to the previous release. It has consisted of both individual work and group meetings. But for this release we have been working more together to collaborate on the difficult parts such as implementation of restapi. We have also been coding two and two and documented it in commits by using "Co-authored-by:". By doing this we have been able to discuss code and how we should solve issues. To get a better overview of the requirements for this release we had one meeting with the teaching assistant. Every group member has been assigned issues and main tasks to resolve and done so.

Similar to the previous release we have been working in branches linked to issues. In this release we have also been using tasks to increase the overview of what every group member do.

In gitlab we have been better at ensuring that all requests are approved by one person
reviewer before the assignee merges it. In that way it is easier to detect errors and conflicts.

## Code quality

### Tests
We have changed and added more unit tests after adding more functionality. The unit tests make sure that the code works correctly. To run all the unit test classes, you can open the project and write the command: mvn test.

### Code quality tools
We have used three code quality analysis tools to make sure our code is up to standards:

*JaCoCo: to check our tests' code coverage
*SpotBug: to spot bugs
*Checkstyle: generates a report regarding the code style

All three generate HTML reports with pointers to what can be improved.


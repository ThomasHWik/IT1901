# UI module
The UI folder contains the ui-related files in our project. This includes the app launcher file, tha app controllers and the fxml files. 

* **App.java:** The application starter
* **AppControllerGames.java:** Controller for the second page in our app
* **AppControllerPadel.java:** Controller for the first page in our app 
* **AppControllerScoreBoard.java:** Controller for the last page in our app

## User interfaces
This module contains the files that is connected to how the user sees our Padel app. In the first page (padel.fxml) the user is taken to a register page where they register players by phonenumber, name and age, and they select how many rounds they want to play and how many double courts they want. The next page (games.fxml) shows courts for each playerpair and the user register the victories for each round. The last page (scoreBoard.fxml) the user sees a scoreboard for the rounds that have been played in this specific game, and a leaderboard for number of victories for all the players that have played ever.

The user interface is made with JavaFX and FXML.
* **PadelApp/ui/src/main/resources/PadelApp/ui:** Contains games.fxml, padel.fxml and scoreBoard.fxml
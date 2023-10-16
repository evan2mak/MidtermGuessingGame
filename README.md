# C323 Midterm Project - Guessing Game: Evan Tomak

This project is a simple guessing game in which you guess a random number between 1-100. The high scores are then stored in a database and listed on a high score screen.

The functionality is described in more detail below:

## Main Screen (Play Game - View High Scores)

[X] The user opens the application and sees a UI interface with various components.

[X] The user has the option of playing a new game or viewing the previous high scores.

[X] If the user plays a new game, they are navigated to the game screen.

[X] If the user views high scores, they are navigated to the high scores screen.

[X] After a game is played, the user's name is displayed with their score, and also a message stating "Play Another Game?"

## Game Screen

[X] The game screen is where the guessing game occurs.

[X] The user must type a title and a guess before pressing ok to make their guess. If not, the user will see an appropriate prompt message.

[X] The user must guess a number between 1-100. If not, the user will see an appropriate prompt message.

[X] If the guess is lower than the random number, they see dialog stating that they need to guess higher. Vice versa if they guess higher than the correct number.

[X] The user has the option of typing in the number or using the +/- buttons to increment and decrement their guess between attempts.

[X] The number of attempts are stored and displayed on screen during the game.

[X] Once the user guesses the correct number, they are navigated back to the home screen.

## High Scores Screen

[X] The high scores screen is where the user can see old scores.

[X] If there have been no games played, the user will see text that states "No high scores yet."

[X] If there have been games played, all of the scores will be stored here in a list.

[X] The list shows the player name and their score.

[X] The user also has the option to delete a score. If they press the delete button, they must confirm or deny the delete.

[X] Lastly, there is a back button to navigate back to the home screen.

##

The following functions/extensions are implemented:

## AppDatabase:

Database that stores the player scores.

getInstance:

Gets the singleton instance of the database.

## DeleteConfirmationDialogFragment:

Fragment that displays a confirmation dialog for deleting a score.

onCreateDialog:

Creates and returns the dialog for score deletion confirmation.

## GameFragment:

Fragment that hosts the game's child fragments.

onViewCreated:

Initializes child fragments when the view is created.

## GameFragmentChild1:

Fragment representing the first child of the game, handling user input and game logic.

onViewCreated:

Initializes UI components and sets up event listeners.

showToast:

Displays a short toast message.

playBuzzSound:

Plays a sound effect for incorrect guesses.

## GameFragmentChild2:

Fragment representing the second child of the game, displaying the number of attempts.

onViewCreated:

Initializes UI components and sets up data observers.

## GameViewModel:

ViewModel for managing game state and interactions.

init:

Initializes the ViewModel and generate a new random number.

incrementAttempts:

Increments the number of attempts.

generateNewRandomNumber:

Generates a new random number between 1 and 100.

saveScore:

Saves the score to the database.

resetGame:

Resets the game state by setting attempts to 0 and generating a new random number.

## GameViewModelFactory:

Factory for creating instances of GameViewModel with a ScoreDao parameter.

create:

Creates and return an instance of GameViewModel or throw an exception for unknown ViewModel classes.

## HighScoreAdapter:

Adapter for displaying high scores in a RecyclerView.

onCreateViewHolder:

Creates a new ViewHolder for the high score item.

onBindViewHolder:

Binds the high score data to the ViewHolder.

ViewHolder:

Class for displaying individual high score items.

ScoreDiffCallback:

Class for calculating the difference between two non-null items in a list.

## HighScoreFragment:

Fragment for displaying the high scores.

onViewCreated:

Sets up the UI components and observes data changes.

## HighScoreViewModel:

ViewModel for managing high score data.

deleteScore:

Deletes a specific score from the database.

## HighScoreViewModelFactory:

Factory for creating an instance of the HighScoreViewModel with a specific ScoreDao.

create:

Creates and returns an instance of the high score view model.

## MainActivity:

Main activity that hosts the navigation component for the app.

onCreate:

Initializes the activity and sets up the NavController.

onSupportNavigationUp:

Handles navigation when the up button in the action bar is pressed.

## MainFragment:

Fragment that displays the main menu of the game.

onViewCreated:

Sets up UI elements and event listeners after the view is created.

## Score:

Entity representing a player's score in the game.

## ScoreDao:

Data Access Object (DAO) for the Score entity.

## Video Walkthrough

Here's a walkthrough of implemented user stories:







## Notes

One of the challenges I faced was changing the game state and appropriate variables (like score, attempts and random number) between games. I also faced challenges implementing navigation between fragments. I also faced challenges with storing data properly within the database.

## License

    Copyright 2023 Evan Tomak.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express implied.

    See the License for the specific language governing permissions and
    limitations under the License.

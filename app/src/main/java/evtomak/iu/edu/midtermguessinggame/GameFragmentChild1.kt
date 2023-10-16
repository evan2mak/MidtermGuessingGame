package evtomak.iu.edu.midtermguessinggame

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

/**
 * Fragment representing the first child of the game, handling user input and game logic.
 */
class GameFragmentChild1 : Fragment(R.layout.fragment_game_child1) {

    // ViewModel shared across fragments for game data and logic
    private val sharedViewModel: GameViewModel by activityViewModels {
        GameViewModelFactory(AppDatabase.getInstance(requireContext()).scoreDao)
    }

    /**
     * Initializes UI components and sets up event listeners.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decrementButton = view.findViewById<ImageButton>(R.id.decrementButton)
        val incrementButton = view.findViewById<ImageButton>(R.id.incrementButton)
        val guessEditText = view.findViewById<EditText>(R.id.guessEditText)
        val okButton = view.findViewById<Button>(R.id.okButton)
        val playerNameEditText = view.findViewById<EditText>(R.id.nameEditText)

        // Decrease the guess number
        decrementButton.setOnClickListener {
            val currentValue = guessEditText.text.toString().toIntOrNull()
            if (currentValue != null && currentValue > 1) {
                guessEditText.setText((currentValue - 1).toString())
            }
        }

        // Increase the guess number
        incrementButton.setOnClickListener {
            val currentValue = guessEditText.text.toString().toIntOrNull()
            if (currentValue != null && currentValue < 100) {
                guessEditText.setText((currentValue + 1).toString())
            }
        }

        // Handle the game logic when the OK button is clicked
        okButton.setOnClickListener {
            val playerName = playerNameEditText.text.toString()
            if (playerName.isBlank()) {
                Toast.makeText(context, "Please enter your name!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val guessString = guessEditText.text.toString()
            if (guessString.isNullOrBlank() || !guessString.all { it.isDigit() }) {
                Toast.makeText(context, "Please enter a valid number!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val guess = guessString.toInt()
            if (guess < 1 || guess > 100) {
                Toast.makeText(context, "Please enter a number between 1 and 100!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sharedViewModel.incrementAttempts()
            if (guess == sharedViewModel.randomNumber.value) {
                // Correct guess
                val score = Score(0, playerName, sharedViewModel.attempts.value ?: 0)
                sharedViewModel.saveScore(score)
                findNavController().navigate(R.id.action_gameFragment_to_mainFragment, bundleOf("playerName" to playerName, "score" to sharedViewModel.attempts.value))
                // Reset the game state
                sharedViewModel.resetGame()
            }
            else if (guess < sharedViewModel.randomNumber.value!!) {
                // Display "Higher" message
                showToast("Guess higher!")
                playBuzzSound()
            }
            else {
                // Display "Lower" message
                showToast("Guess lower!")
                playBuzzSound()
            }
        }
    }

    /**
     * Displays a short toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Plays a sound effect.
     */
    private fun playBuzzSound() {
        val mediaPlayer = MediaPlayer.create(context, R.raw.buzz)
        mediaPlayer.setOnCompletionListener { it.release() }
        mediaPlayer.start()
    }
}

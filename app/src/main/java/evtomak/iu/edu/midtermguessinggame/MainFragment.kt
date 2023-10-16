package evtomak.iu.edu.midtermguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

/**
 * Fragment that displays the main menu of the game.
 */
class MainFragment : Fragment(R.layout.fragment_main) {

    // Shared ViewModel instance for game data
    private val sharedViewModel: GameViewModel by activityViewModels {
        GameViewModelFactory(AppDatabase.getInstance(requireContext()).scoreDao)
    }

    /**
     * Sets up UI elements and event listeners after the view is created.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Display the player's score if available
        arguments?.let {
            val playerName = it.getString("playerName")
            val score = it.getInt("score")
            view.findViewById<TextView>(R.id.welcomeTextView).text = "$playerName score: $score. Play another game?"
        }

        // Set up the "Play Game" button
        view.findViewById<Button>(R.id.playGameButton).setOnClickListener {
            // Reset the game state
            sharedViewModel.resetGame()

            // Navigate to the game screen
            findNavController().navigate(R.id.action_mainFragment_to_gameFragment)
        }

        // Set up the "View High Scores" button
        view.findViewById<Button>(R.id.viewHighScoresButton).setOnClickListener {
            // Navigate to the high scores screen
            findNavController().navigate(R.id.action_mainFragment_to_highScoreFragment)
        }
    }
}

package evtomak.iu.edu.midtermguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels

/**
 * Fragment representing the second child of the game, displaying the number of attempts.
 */
class GameFragmentChild2 : Fragment(R.layout.fragment_game_child2) {

    // ViewModel shared across fragments for game data and logic
    private val sharedViewModel: GameViewModel by activityViewModels {
        GameViewModelFactory(AppDatabase.getInstance(requireContext()).scoreDao)
    }

    /**
     * Initializes UI components and sets up data observers.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val attemptsTextView = view.findViewById<TextView>(R.id.attemptsTextView)

        // Observe and display the number of attempts
        sharedViewModel.attempts.observe(viewLifecycleOwner) { attempts ->
            attemptsTextView.text = "Number of attempts: $attempts"
        }
    }
}

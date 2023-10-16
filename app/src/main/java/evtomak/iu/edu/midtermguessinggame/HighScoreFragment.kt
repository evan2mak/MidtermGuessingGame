package evtomak.iu.edu.midtermguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * Fragment for displaying the high scores.
 */
class HighScoreFragment : Fragment(R.layout.fragment_high_score) {

    // ViewModel for managing high score data
    private val viewModel: HighScoreViewModel by viewModels {
        HighScoreViewModelFactory(AppDatabase.getInstance(requireContext()).scoreDao)
    }

    /**
     * Set up the UI components and observe data changes.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate back to the main screen
        val backButton = view.findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_highScoreFragment_to_mainFragment)
        }

        // UI components for displaying scores and empty state
        val noScoresTextView = view.findViewById<TextView>(R.id.noScoresTextView)
        val highScoresRecyclerView = view.findViewById<RecyclerView>(R.id.highScoresRecyclerView)

        // Set up the RecyclerView layout
        highScoresRecyclerView.layoutManager = LinearLayoutManager(context)

        // Set up RecyclerView with scores and handle score deletion
        val adapter = HighScoreAdapter { score ->
            // Show the delete confirmation dialog
            val dialog = DeleteConfirmationDialogFragment {
                viewModel.deleteScore(score)
            }
            dialog.show(childFragmentManager, "DeleteConfirmationDialog")
        }
        highScoresRecyclerView.adapter = adapter

        // Observe score changes and update the UI accordingly
        viewModel.scores.observe(viewLifecycleOwner) { scores ->
            if (scores.isNullOrEmpty()) {
                noScoresTextView.visibility = View.VISIBLE
                highScoresRecyclerView.visibility = View.GONE
            }
            else {
                noScoresTextView.visibility = View.GONE
                highScoresRecyclerView.visibility = View.VISIBLE
            }
            adapter.submitList(scores)
        }
    }
}

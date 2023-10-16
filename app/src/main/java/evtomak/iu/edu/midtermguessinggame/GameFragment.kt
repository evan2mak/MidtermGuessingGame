package evtomak.iu.edu.midtermguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View

/**
 * Fragment that hosts the game's child fragments.
 */
class GameFragment : Fragment(R.layout.fragment_game) {

    /**
     * Initializes child fragments when the view is created.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add child fragments dynamically
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment1Container, GameFragmentChild1())
            .replace(R.id.fragment2Container, GameFragmentChild2())
            .commit()
    }
}

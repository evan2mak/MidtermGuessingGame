package evtomak.iu.edu.midtermguessinggame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory for creating instances of GameViewModel with a ScoreDao parameter.
 */
class GameViewModelFactory(private val scoreDao: ScoreDao) : ViewModelProvider.Factory {

    /**
     * Create and return an instance of GameViewModel or throw an exception for unknown ViewModel classes.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(scoreDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

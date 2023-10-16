package evtomak.iu.edu.midtermguessinggame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory for creating an instance of the HighScoreViewModel with a specific ScoreDao.
 */
class HighScoreViewModelFactory(private val scoreDao: ScoreDao) : ViewModelProvider.Factory {

    /**
     * Creates and returns an instance of the ViewModel.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HighScoreViewModel::class.java)) {
            return HighScoreViewModel(scoreDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

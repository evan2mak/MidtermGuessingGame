package evtomak.iu.edu.midtermguessinggame

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel for managing high score data.
 */
class HighScoreViewModel(private val scoreDao: ScoreDao) : ViewModel() {

    // LiveData to observe changes in the list of scores
    val scores: LiveData<List<Score>> = scoreDao.getAllScores()

    /**
     * Delete a specific score from the database.
     */
    fun deleteScore(score: Score) {
        viewModelScope.launch(Dispatchers.IO) {
            scoreDao.delete(score)
        }
    }
}

package evtomak.iu.edu.midtermguessinggame

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel for managing game state and interactions.
 */
class GameViewModel(private val scoreDao: ScoreDao) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> get() = _score

    private val _attempts = MutableLiveData<Int>(0)
    val attempts: LiveData<Int> get() = _attempts

    private val _randomNumber = MutableLiveData<Int>((1..100).random())
    val randomNumber: LiveData<Int> get() = _randomNumber

    // Initialize the ViewModel and generate a new random number
    init {
        generateNewRandomNumber()
    }

    /**
     * Increment the number of attempts.
     */
    fun incrementAttempts() {
        _attempts.value = (_attempts.value ?: 0) + 1
    }

    /**
     * Generate a new random number between 1 and 100.
     */
    fun generateNewRandomNumber() {
        _randomNumber.value = (1..100).random()
        Log.d("GameViewModel", "Generated random number: ${_randomNumber.value}")
    }

    /**
     * Save the score to the database.
     */
    fun saveScore(score: Score) {
        viewModelScope.launch(Dispatchers.IO) {
            scoreDao.insert(score)
        }
    }

    /**
     * Reset the game state by setting attempts to 0 and generating a new random number.
     */
    fun resetGame() {
        _attempts.value = 0
        generateNewRandomNumber()
    }
}


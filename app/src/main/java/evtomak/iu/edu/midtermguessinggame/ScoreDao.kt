package evtomak.iu.edu.midtermguessinggame

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Data Access Object (DAO) for the Score entity.
 */
@Dao
interface ScoreDao {
    @Query("SELECT * FROM score ORDER BY score DESC")
    fun getAllScores(): LiveData<List<Score>>

    @Insert
    fun insert(score: Score)

    @Delete
    fun delete(score: Score)
}

package evtomak.iu.edu.midtermguessinggame

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity representing a player's score in the game.
 */
@Entity
data class Score(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val playerName: String,
    val score: Int
)


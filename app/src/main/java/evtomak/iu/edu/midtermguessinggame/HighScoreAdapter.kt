package evtomak.iu.edu.midtermguessinggame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for displaying high scores in a RecyclerView.
 */
class HighScoreAdapter(private val onDeleteClick: (Score) -> Unit) : ListAdapter<Score, HighScoreAdapter.ViewHolder>(ScoreDiffCallback()) {

    /**
     * Create a new ViewHolder for the high score item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_high_score, parent, false)
        return ViewHolder(view, onDeleteClick)
    }

    /**
     * Bind the high score data to the ViewHolder.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val score = getItem(position)
        holder.bind(score)
    }

    /**
     * ViewHolder for displaying individual high score items.
     */
    class ViewHolder(itemView: View, private val onDeleteClick: (Score) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val playerNameTextView: TextView = itemView.findViewById(R.id.playerNameTextView)
        private val playerScoreTextView: TextView = itemView.findViewById(R.id.playerScoreTextView)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)

        /**
         * Bind the score data to the views.
         */
        fun bind(score: Score) {
            playerNameTextView.text = score.playerName
            playerScoreTextView.text = "Score: ${score.score}"
            deleteButton.setOnClickListener { onDeleteClick(score) }
        }
    }

    /**
     * Callback for calculating the diff between two non-null items in a list.
     */
    class ScoreDiffCallback : DiffUtil.ItemCallback<Score>() {
        /**
         * Check if two scores have the same ID.
         */
        override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem.id == newItem.id
        }

        /**
         * Check if two scores are identical.
         */
        override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem == newItem
        }
    }
}

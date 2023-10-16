package evtomak.iu.edu.midtermguessinggame

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

/**
 * Fragment that displays a confirmation dialog for deleting a score.
 */
class DeleteConfirmationDialogFragment(private val onConfirm: () -> Unit) : DialogFragment() {

    /**
     * Creates and returns the dialog for score deletion confirmation.
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
            .setTitle("Delete Score")
            .setMessage("Are you sure you want to delete this score?")
            .setPositiveButton("Yes") { _, _ ->
                onConfirm.invoke()
            }
            .setNegativeButton("No", null)
            .create()
    }
}

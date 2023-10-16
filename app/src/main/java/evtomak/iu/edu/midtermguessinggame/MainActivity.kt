package evtomak.iu.edu.midtermguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * Main activity that hosts the navigation component for the app.
 */
class MainActivity : AppCompatActivity() {

    // Controller for navigating between fragments
    private lateinit var navController: NavController

    /**
     * Initializes the activity and sets up the NavController.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve the NavHostFragment and set up the NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
    }

    /**
     * Handles navigation when the up button in the action bar is pressed.
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

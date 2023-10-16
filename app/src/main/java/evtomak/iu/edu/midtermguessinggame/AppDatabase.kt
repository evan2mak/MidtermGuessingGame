package evtomak.iu.edu.midtermguessinggame

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Score::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val scoreDao: ScoreDao
    companion object {
        // Singleton instance of the database
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Get the singleton instance of the database.
         */
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    Log.d("Database", "Creating new database instance")
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                    INSTANCE = instance
                    Log.d("Database", "Database instance created")
                }
                else {
                    Log.d("Database", "Reusing existing database instance")
                }
                return instance
            }
        }
    }
}

package course.intermediate.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import course.intermediate.notes.models.Note
import course.intermediate.notes.models.Tag
import course.intermediate.notes.models.TaskEntity
import course.intermediate.notes.models.Todo

const val DATABASE_SCHEMA_VERSION = 1
const val DB_NAME = "local-db"

@Database(version = DATABASE_SCHEMA_VERSION, entities = [TaskEntity::class, Todo::class, Tag::class, Note::class])
abstract class RoomDatabaseClient : RoomDatabase() {

    // Insert DAOs bellow
    abstract fun noteDAO(): NoteDAO
    abstract fun taskDAO(): TaskDAO

    companion object {
        private var instance: RoomDatabaseClient? = null
        fun getInstance(context: Context): RoomDatabaseClient {
            if (instance == null) {
                instance = createDatabase(context)
            }
            return instance!!
        }

        // TODO move away from main thread queries (hint: coroutines)
        private fun createDatabase(context: Context): RoomDatabaseClient {
            return Room.databaseBuilder(context, RoomDatabaseClient::class.java, DB_NAME)
                .build()
        }
    }
}

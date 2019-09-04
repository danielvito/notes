package course.intermediate.notes.notes

import course.intermediate.notes.application.NoteApplication
import course.intermediate.notes.database.RoomDatabaseClient
import course.intermediate.notes.models.Note
import kotlinx.coroutines.async
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import javax.inject.Inject

const val TIMEOUT_DURATION_MILLIS = 3000L

class NoteLocalModel @Inject constructor() : INoteModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    private fun performOperationWithTimeout(function: () -> Unit, callback: SuccessCallback) {
        GlobalScope.launch {
            val job = async {
                try {
                    withTimeout(TIMEOUT_DURATION_MILLIS) {
                        function.invoke()
                    }
                } catch (e: java.lang.Exception) {
                    callback.invoke(false)
                }
            }
            job.await()
            callback.invoke(true)
        }
    }

    override fun addNote(note: Note, callback: SuccessCallback) {
        performOperationWithTimeout(
            {
                databaseClient.noteDAO().addNote(note)
            },
            callback
        )
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        performOperationWithTimeout(
            {
                databaseClient.noteDAO().updateNote(note)
            },
            callback
        )
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        performOperationWithTimeout(
            {
                databaseClient.noteDAO().deleteNote(note)
            },
            callback
        )
    }

    override fun retrieveNotes(callback: (List<Note>?) -> Unit) {
        GlobalScope.launch {
            val job = async {
                withTimeoutOrNull(TIMEOUT_DURATION_MILLIS) {
                    databaseClient.noteDAO().retrieveNote()
                }
            }
            callback.invoke(job.await())
        }
    }
}
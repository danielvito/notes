package course.intermediate.notes.notes

import android.util.Log
import course.intermediate.notes.application.NoteApplication
import course.intermediate.notes.database.RoomDatabaseClient
import course.intermediate.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor() : INoteModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Note> = retrieveNotes().toMutableList()
//        mutableListOf(
//        Note(description = "Note Testing 1"),
//        Note(description = "Note Testing 2")
//    )

    override fun addNote(note: Note, callback: SuccessCallback) {
        Log.d("UdemyCourse", note.toString())
        databaseClient.noteDAO().addNote(note)
        callback.invoke(true)
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().updateNote(note)
        callback.invoke(true)
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().deteleNote(note)
        callback.invoke(true)
    }

    override fun retrieveNotes(): List<Note> = databaseClient.noteDAO().retrieveNote()
}
package course.intermediate.notes.notes

import course.intermediate.notes.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel {

    override fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Note Testing 1"),
        Note("Note Testing 2")
    )

    override fun addNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retriveNotes(): List<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
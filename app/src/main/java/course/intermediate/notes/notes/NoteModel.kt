package course.intermediate.notes.notes

import course.intermediate.notes.models.Note
import javax.inject.Inject

class NoteModel @Inject constructor() {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Note Testing 1"),
        Note("Note Testing 2")
    )
}
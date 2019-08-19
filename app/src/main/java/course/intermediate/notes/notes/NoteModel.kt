package course.intermediate.notes.notes

import course.intermediate.notes.models.Note

class NoteModel {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Note Testing 1"),
        Note("Note Testing 2")
    )
}
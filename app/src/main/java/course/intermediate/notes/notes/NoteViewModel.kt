package course.intermediate.notes.notes

import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Note

class NoteViewModel : ViewModel() {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Note Testing 1"),
        Note("Note Testing 2")
    )

}
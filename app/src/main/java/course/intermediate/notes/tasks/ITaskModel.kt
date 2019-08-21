package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task

typealias SuccessCallback = (Boolean) -> Unit

interface ITaskModel {

    fun addNote(task: Task, callback: SuccessCallback)
    fun updateNote(task: Task, callback: SuccessCallback)
    fun deleteNote(task: Task, callback: SuccessCallback)
    fun retriveNotes(): List<Task>
    fun getFakeData(): List<Task>

}

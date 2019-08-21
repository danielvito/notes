package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor(): ITaskModel {

    override fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Testing 1", mutableListOf(
                Todo("Todo 11"),
                Todo("Todo 12", true),
                Todo("Todo 13"),
                Todo("Todo 14", true)
            )
        ),
        Task("Testing 2"),
        Task(
            "Testing 3", mutableListOf(
                Todo("Todo 31"),
                Todo("Todo 32", true),
                Todo("Todo 33"),
                Todo("Todo 34", true)
            )
        )
    )

    override fun addNote(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateNote(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteNote(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retriveNotes(): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

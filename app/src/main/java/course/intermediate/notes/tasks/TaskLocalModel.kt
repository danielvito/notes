package course.intermediate.notes.tasks

import android.util.Log
import course.intermediate.notes.application.NoteApplication
import course.intermediate.notes.database.RoomDatabaseClient
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Testing 1", mutableListOf(
                Todo(description = "Todo 11"),
                Todo(description = "Todo 12", isComplete = true),
                Todo(description = "Todo 13"),
                Todo(description = "Todo 14", isComplete = true)
            )
        ),
        Task("Testing 2"),
        Task(
            "Testing 3", mutableListOf(
                Todo(description = "Todo 31"),
                Todo(description = "Todo 32", isComplete = true),
                Todo(description = "Todo 33"),
                Todo(description = "Todo 34", isComplete = true)
            )
        )
    )

    override fun addTask(task: Task, callback: SuccessCallback) {
        Log.d("Udemy course", task.toString())
        callback.invoke(true)
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveTasks(): List<Task> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}

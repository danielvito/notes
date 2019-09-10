package course.intermediate.notes.tasks

import course.intermediate.notes.application.NoteApplication
import course.intermediate.notes.database.RoomDatabaseClient
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import javax.inject.Inject

const val TIMEOUT_DURATION_MILLIS = 3000L

class TaskLocalModel @Inject constructor() : ITaskModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    private suspend fun performOperationWithTimeout(function: () -> Unit, callback: SuccessCallback) {
        val job = GlobalScope.async {
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

    override suspend fun addTask(task: Task, callback: SuccessCallback) {
        GlobalScope.launch {
            val masterJob = async {
                // adds task entity component
                try {
                    databaseClient.taskDAO().addTask(task)
                } catch (e: Exception) {
                    callback.invoke(false)
                }
                // adds todos list component
                addTodosJob(task)
            }
            masterJob.await()
            callback.invoke(true)
        }
    }

    override suspend fun updateTask(task: Task, callback: SuccessCallback) {
        performOperationWithTimeout(
            {
                databaseClient.taskDAO().updateTask(task)
            },
            callback
        )
    }

    override suspend fun updateTodo(todo: Todo, callback: SuccessCallback) {
        performOperationWithTimeout(
            {
                databaseClient.taskDAO().updateTodo(todo)
            },
            callback
        )
    }

    override suspend fun deleteTask(task: Task, callback: SuccessCallback) {
        performOperationWithTimeout(
            {
                databaseClient.taskDAO().deleteTask(task)
            },
            callback
        )
    }

    private fun addTodosJob(task: Task): Job = GlobalScope.async {
        task.todos.forEach {
            databaseClient.taskDAO().addTodo(it)
        }
    }

    override suspend fun retrieveTasks(callback: (List<Task>?) -> Unit) {
        GlobalScope.launch {
            val job = async {
                withTimeoutOrNull(course.intermediate.notes.notes.TIMEOUT_DURATION_MILLIS) {
                    databaseClient.taskDAO().retrieveTask()
                }
            }
            callback.invoke(job.await())
        }
    }
}

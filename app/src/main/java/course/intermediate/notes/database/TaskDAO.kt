package course.intermediate.notes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.TaskEntity
import course.intermediate.notes.models.Todo

@Dao
interface TaskDAO {

    @Insert
    fun addTask(note: TaskEntity)

    @Insert
    fun addTodo(todo: Todo)

    @Update
    fun updateTask(note: TaskEntity)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTask(note: TaskEntity)

    @Query("SELECT * FROM tasks")
    fun retrieveTask(): MutableList<Task>
}

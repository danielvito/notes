package course.intermediate.notes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.TaskEntity

@Dao
interface TaskDAO {

    @Insert
    fun addTask(note: TaskEntity)

    @Update
    fun updateTask(note: TaskEntity)

    @Delete
    fun deteleTask(note: TaskEntity)

    @Query("SELECT * FROM tasks")
    fun retrieveTask(): MutableList<Task>
}

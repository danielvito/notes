package course.intermediate.notes.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.UUID

class Task @JvmOverloads constructor(
    title: String,
    @Relation(
        parentColumn = "uid",
        entityColumn = "taskId",
        entity = Todo::class
    )
    val todos: MutableList<Todo> = mutableListOf(),
    tag: Tag? = null
) : TaskEntity(title = title, tag = tag) {

    fun isComplete() = todos.firstOrNull { !it.isComplete }?.isComplete ?: true

    init {
        todos.forEach {
            it.taskId = uid
        }
    }
}

@Entity(tableName = "tasks")
open class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = UUID.randomUUID().leastSignificantBits,
    @ColumnInfo
    var title: String,
    @Embedded
    var tag: Tag? = null
)

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    @ForeignKey(
        parentColumns = ["uid"],
        childColumns = ["taskId"],
        entity = TaskEntity::class,
        onDelete = CASCADE
    )
    var taskId: Long? = null,
    @ColumnInfo
    var description: String,
    @ColumnInfo
    var isComplete: Boolean = false
)

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    @ColumnInfo
    var description: String,
    @Embedded
    var tag: Tag? = null
)

@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey
    var name: String,
    @ColumnInfo(name = "color_resource_id")
    var colourResId: Int
)
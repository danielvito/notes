package course.intermediate.notes.models

import org.junit.Before
import org.junit.Test

class TaskTest {

    private lateinit var testTask: Task

    @Before
    fun setUp() {
        testTask = getFakeTask()
    }

    @Test
    fun taskIsIncompleteOnInit() {
        assert(!testTask.isComplete())
    }

    @Test
    fun taskIsCompleteAfterAllTodosChecked() {
        testTask.todos.forEach {
            it.isComplete = true
        }
        assert(testTask.isComplete())
    }

    private fun getFakeTask(): Task = Task(title = "Testing task", todos = getFakeTodos())

    private fun getFakeTodos(): MutableList<Todo> = mutableListOf(
        Todo(description = "Todo 1", isComplete = true),
        Todo(description = "Todo 2"),
        Todo(description = "Todo 3")
    )
}
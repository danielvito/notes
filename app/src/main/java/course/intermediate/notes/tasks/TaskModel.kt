package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo

class TaskModel {

    fun getFakeData(): MutableList<Task> = mutableListOf(
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

}
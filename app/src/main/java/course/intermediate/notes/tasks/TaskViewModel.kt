package course.intermediate.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo

class TaskViewModel : ViewModel() {

    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    init {
        _taskListLiveData.postValue(getFakeData())
    }

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

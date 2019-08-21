package course.intermediate.notes.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Task
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class TaskViewModel : ViewModel(), TaskListViewContract {

    @Inject
    lateinit var model: ITaskModel

    private val _taskListLiveData: MutableLiveData<List<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<List<Task>> = _taskListLiveData

    init {
        val scope = Toothpick.openScope(this)
        scope.installModules(Module().apply {
            bind(ITaskModel::class.java).toInstance(TaskLocalModel())
        })
        Toothpick.inject(this, scope)
        _taskListLiveData.postValue(model.getFakeData())
    }

    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete
    }
}

package course.intermediate.notes.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.models.Task
import kotlinx.android.synthetic.main.fragment_tasks_list.view.*

class TaskListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: TaskAdapter
    private lateinit var touchActionDelegate: TasksListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: TaskListViewContract

    fun initView(taDelegate: TasksListFragment.TouchActionDelegate, daActionDelegate: TaskListViewContract) {
        setDelegates(taDelegate, daActionDelegate)
        setUpView()
    }

    private fun setDelegates(
        taDelegate: TasksListFragment.TouchActionDelegate,
        daActionDelegate: TaskListViewContract
    ) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daActionDelegate
    }

    private fun setUpView() {
        adapter = TaskAdapter(touchActionDelegate = touchActionDelegate, dataActionDelegate = dataActionDelegate)
        recyclerView.adapter = adapter
    }

    fun updateList(list: MutableList<Task>) {
        adapter.updateList(list)
    }
}

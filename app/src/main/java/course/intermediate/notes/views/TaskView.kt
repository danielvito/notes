package course.intermediate.notes.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.models.Task
import intermediate.course.notes.R
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit, deleteCallback: () -> Unit) {
        resetChieldViews()
        this.task = task
        initTaskLine(deleteCallback)
        addChildViews(todoCheckedCallback)
    }

    private fun resetChieldViews() {
        todoContainer.removeAllViewsInLayout()
    }

    private fun initTaskLine(deleteCallback: () -> Unit) {
        titleView.text = task.title

        imageButton.setOnClickListener {
            deleteCallback.invoke()
        }

        if (task.isComplete()) {
            this@TaskView.titleView.setStrikeThrough()
        } else {
            this@TaskView.titleView.removeStrikeThrough()
        }
    }

    private fun addChildViews(todoCheckedCallback: (Int, Boolean) -> Unit) {
        task.todos.forEachIndexed { todoIndex, todo ->
            val todoView =
                (LayoutInflater.from(context).inflate(R.layout.view_todo, todoContainer, false) as TodoView).apply {
                    initView(todo) { isChecked ->
                        todoCheckedCallback.invoke(todoIndex, isChecked)
                    }
                }
            todoContainer.addView(todoView)
        }
    }
}

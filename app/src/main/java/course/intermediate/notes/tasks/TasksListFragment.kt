package course.intermediate.notes.tasks


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo

import intermediate.course.notes.R
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(mutableListOf(
            Task("Testing 1", mutableListOf(
                Todo("Todo 1"),
                Todo("Todo 2", true),
                Todo("Todo 3"),
                Todo("Todo 4", true)
            )),
            Task("Testing 2")
        ))
        recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = TasksListFragment()
    }

}

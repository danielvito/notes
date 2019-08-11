package course.intermediate.notes.notes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.notes.models.Note

import intermediate.course.notes.R
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class NotesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = NoteAdapter(mutableListOf(
            Note("Note Testing 1"),
            Note("Note Testing 2")
        ))
        recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

}

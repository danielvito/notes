package course.intermediate.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.foundations.BaseRecyclerAdapter
import course.intermediate.notes.models.Note
import course.intermediate.notes.navigation.NavigationActivity
import course.intermediate.notes.views.NoteView
import intermediate.course.notes.R
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
) : BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_INFO) {
            NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
        } else {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
        }

    class NoteViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(note: Note, listIndex: Int) {
            (view as NoteView).initView(note)
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit, listIndex: Int) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }
    }
}

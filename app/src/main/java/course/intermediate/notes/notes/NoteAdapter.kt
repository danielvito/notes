package course.intermediate.notes.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.intermediate.notes.foundations.BaseRecyclerAdapter
import course.intermediate.notes.models.Note
import course.intermediate.notes.views.NoteView
import intermediate.course.notes.R

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf()
): BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent,false))

    class ViewHolder(view: View): BaseViewHolder<Note>(view) {

        override fun onBind(note: Note) {
            (view as NoteView).initView(note)
        }
    }
}

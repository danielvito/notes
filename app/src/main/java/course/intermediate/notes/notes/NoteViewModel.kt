package course.intermediate.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.Note
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel : ViewModel(), NoteListViewContract {

    @Inject
    lateinit var model: INoteModel

    private val _noteListLiveData: MutableLiveData<List<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<List<Note>> = _noteListLiveData

    init {
        val scope = Toothpick.openScope(this)
        scope.installModules(Module().apply {
            bind(INoteModel::class.java).toInstance(NoteLocalModel())
        })
        Toothpick.inject(this, scope)
        _noteListLiveData.postValue(model.getFakeData())
    }

}

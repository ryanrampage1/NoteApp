package com.ryancasler.noteapp.note.list

import com.ryancasler.noteapp.base.BasePresenter
import com.ryancasler.noteapp.db.CipherHelper
import com.ryancasler.noteapp.db.NoteDao
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class NoteListPresenter @Inject constructor(
        private val cipherHelper: CipherHelper,
        private val view: NoteListView
) : BasePresenter() {

    override fun onResume() {
        super.onResume()
        loadNotes()
    }

    fun loadNotes() {
        val noteDao = cipherHelper.map[NoteDao.NAME] as NoteDao

        launch(UI) {
            val notes = noteDao.getNotes().await()
            view.showList(notes)
        }
    }
}
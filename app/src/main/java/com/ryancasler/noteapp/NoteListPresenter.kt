package com.ryancasler.noteapp

import com.ryancasler.noteapp.base.BasePresenter
import com.ryancasler.noteapp.db.CipherHelper
import com.ryancasler.noteapp.db.NoteDao
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class NoteListPresenter @Inject constructor(private val cipherHelper: CipherHelper)
    : BasePresenter() {

    fun loadNotes() {
        val noteDao = cipherHelper.map[NoteDao.NAME] as NoteDao

        launch(UI) {
            noteDao.getNotes().await()
        }
    }
}
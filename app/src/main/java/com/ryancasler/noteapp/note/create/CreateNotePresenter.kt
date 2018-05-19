package com.ryancasler.noteapp.note.create

import com.ryancasler.noteapp.base.BasePresenter
import com.ryancasler.noteapp.db.CipherHelper
import com.ryancasler.noteapp.db.NoteDao
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class CreateNotePresenter @Inject constructor(
        private val cipherHelper: CipherHelper,
        private val view: CreateNoteView
): BasePresenter() {

    fun createNote(title: String, author: String) {
            val noteDao = cipherHelper.map[NoteDao.NAME] as NoteDao

            launch(UI) {
                noteDao.addNote(title, author).await()

                view.onNoteAdded()
            }
    }

}
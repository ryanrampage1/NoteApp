package com.ryancasler.noteapp

import android.app.Activity
import android.os.Bundle
import com.ryancasler.noteapp.db.CipherHelper
import com.ryancasler.noteapp.db.NoteDao
import kotlinx.android.synthetic.main.activity_create_note.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by Ryan Casler on 4/12/18
 */
class CreateNoteActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        submitButton.setOnClickListener({
            val helper = CipherHelper.instance

            val noteDao = helper.map[NoteDao.NAME] as NoteDao

            launch(UI) {
                noteDao.addNote(
                        noteEditText.text.toString(),
                        authorEditText.text.toString()
                ).await()

                finish()
            }
        })
    }
}

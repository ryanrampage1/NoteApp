package com.ryancasler.noteapp.note.create

import android.os.Bundle
import com.ryancasler.noteapp.R
import com.ryancasler.noteapp.base.BaseActivity

import kotlinx.android.synthetic.main.activity_create_note.*

import javax.inject.Inject

/**
 * Created by Ryan Casler on 4/12/18
 */
class CreateNoteActivity : BaseActivity<CreateNotePresenter>(), CreateNoteView {

    @Inject
    lateinit var createNotePresenter: CreateNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        submitButton.setOnClickListener({
            getPresenter().createNote(
                    noteEditText.text.toString(),
                    authorEditText.text.toString()
            )
        })
    }

    override fun onNoteAdded() = finish()

    override fun getPresenter() = createNotePresenter
}

package com.ryancasler.noteapp.note.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.ryancasler.noteapp.R
import com.ryancasler.noteapp.base.BaseActivity
import com.ryancasler.noteapp.model.Note
import com.ryancasler.noteapp.note.create.CreateNoteActivity

import kotlinx.android.synthetic.main.activity_note_list.*

import javax.inject.Inject

class NoteListActivity : BaseActivity<NoteListPresenter>(), NoteListView {

    private val recyclerViewAdapter = NoteRecyclerViewAdapter()

    @Inject
    lateinit var noteListPresenter: NoteListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        setUpRecyclerView()

        fab.setOnClickListener({
            startActivity(Intent(this, CreateNoteActivity::class.java))
        })
    }

    override fun getPresenter(): NoteListPresenter {
        return noteListPresenter
    }

    private fun setUpRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val decoration = DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(decoration)

        recyclerView.adapter = recyclerViewAdapter
    }

    override fun showList(notes: List<Note>) {
        recyclerViewAdapter.notes = notes
    }
}

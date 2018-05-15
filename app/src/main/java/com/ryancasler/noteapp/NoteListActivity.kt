package com.ryancasler.noteapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.ryancasler.noteapp.adapter.NoteRecyclerViewAdapter
import com.ryancasler.noteapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_note_list.*
import javax.inject.Inject

class NoteListActivity : BaseActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val recyclerViewAdapter = NoteRecyclerViewAdapter()

    @Inject
    lateinit var presenter: NoteListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        setUpRecyclerView()

        fab.setOnClickListener({
            startActivity(Intent(this, CreateNoteActivity::class.java))
        })
    }

    override fun onResume() {
        super.onResume()

        presenter.loadNotes()
    }

    private fun setUpRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val decoration = DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(decoration)

        recyclerView.adapter = recyclerViewAdapter
    }
}

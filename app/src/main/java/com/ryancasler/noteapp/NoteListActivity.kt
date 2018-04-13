package com.ryancasler.noteapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.ryancasler.noteapp.adapter.NoteRecyclerViewAdapter
import com.ryancasler.noteapp.db.CipherHelper
import com.ryancasler.noteapp.db.NoteDao
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private val helper = CipherHelper.instance

    private lateinit var linearLayoutManager: LinearLayoutManager

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

        // TODO: Dont make a new adapter every time.. look into adapter loading the data
        val noteDao = helper.map[NoteDao.NAME] as NoteDao
        val notes = noteDao.getNotes()
        recyclerView.adapter = NoteRecyclerViewAdapter(notes)
    }

    private fun setUpRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val decoration = DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(decoration)
    }
}

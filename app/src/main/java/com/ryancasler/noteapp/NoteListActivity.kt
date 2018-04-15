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
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class NoteListActivity : AppCompatActivity() {

    private val helper = CipherHelper.instance
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val recyclerViewAdapter = NoteRecyclerViewAdapter()

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

        val noteDao = helper.map[NoteDao.NAME] as NoteDao

        launch(UI) {
            recyclerViewAdapter.notes = noteDao.getNotes().await()
            recyclerViewAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val decoration = DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(decoration)

        recyclerView.adapter = recyclerViewAdapter
    }
}

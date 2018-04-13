package com.ryancasler.noteapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ryancasler.noteapp.R
import com.ryancasler.noteapp.inflateView
import com.ryancasler.noteapp.model.Note
import kotlinx.android.synthetic.main.note_item.view.*

/**
 * Created by Ryan Casler on 4/12/18
 */
class NoteRecyclerViewAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NoteRecyclerViewAdapter.NoteHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteHolder(parent.inflateView(R.layout.note_item))

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val item = notes[position]

        holder.idText.text = "Id: ${item.id}"
        holder.noteText.text = "Note: ${item.note}"
        holder.authorText.text = "Author: ${item.author}"
    }

    class NoteHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idText = view.idText
        val noteText = view.noteText
        val authorText = view.authorText
    }
}
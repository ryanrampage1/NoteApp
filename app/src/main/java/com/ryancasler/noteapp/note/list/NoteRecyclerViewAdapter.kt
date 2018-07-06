package com.ryancasler.noteapp.note.list

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
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
class NoteRecyclerViewAdapter : ListAdapter<Note, NoteRecyclerViewAdapter.NoteHolder>(NoteDiffUtilInstance)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteHolder(parent.inflateView(R.layout.note_item))

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val item = getItem(position)

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

object NoteDiffUtilInstance: DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note?, newItem: Note?) =  oldItem?.id == newItem?.id

    override fun areContentsTheSame(oldItem: Note?, newItem: Note?) = oldItem?.let {
            newItem?.note == it.note
    } ?: false
}

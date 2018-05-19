package com.ryancasler.noteapp.note.list

import com.ryancasler.noteapp.base.BaseView
import com.ryancasler.noteapp.model.Note

/**
 * Created by Ryan Casler on 5/19/18
 */
interface NoteListView : BaseView {
    fun showList(notes: List<Note>)
}
package com.ryancasler.noteapp.note.list

import dagger.Module
import dagger.Provides

@Module
open class NoteListModule {

    @Provides
    fun provideNoteListView(activity: NoteListActivity) = activity as NoteListView
}
package com.ryancasler.noteapp.note.create

import dagger.Module
import dagger.Provides

@Module
open class CreateNoteModule {

    @Provides
    fun provideNoteListView(activity: CreateNoteActivity) = activity as CreateNoteView
}
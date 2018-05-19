package com.ryancasler.noteapp.note

import com.ryancasler.noteapp.note.create.CreateNoteActivity
import com.ryancasler.noteapp.note.create.CreateNoteModule
import com.ryancasler.noteapp.note.list.NoteListActivity
import com.ryancasler.noteapp.note.list.NoteListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ryan Casler on 5/14/18
 */

@Module
abstract class NoteUIModule {

    @ContributesAndroidInjector(modules = [NoteListModule::class])
    abstract fun noteListScreen(): NoteListActivity

    @ContributesAndroidInjector(modules = [CreateNoteModule::class])
    abstract fun addNoteScreen(): CreateNoteActivity

}
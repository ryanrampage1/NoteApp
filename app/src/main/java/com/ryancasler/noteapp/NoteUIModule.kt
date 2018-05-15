package com.ryancasler.noteapp

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ryan Casler on 5/14/18
 */

@Module
interface NoteUIModule {

    @ContributesAndroidInjector(modules = [NoteListModule::class])
    fun noteListScreen(): NoteListActivity

}
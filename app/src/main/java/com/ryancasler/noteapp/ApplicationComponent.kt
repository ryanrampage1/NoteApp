package com.ryancasler.noteapp

import com.ryancasler.noteapp.note.NoteUIModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NoteUIModule::class
])
interface ApplicationComponent {
    fun inject(app: App)
}
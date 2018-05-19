package com.ryancasler.noteapp

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ryan Casler on 5/14/18
 */

@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = app

}
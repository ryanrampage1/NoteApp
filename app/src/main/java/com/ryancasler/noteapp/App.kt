package com.ryancasler.noteapp

import android.app.Application

/**
 * Created by Ryan Casler on 4/12/18
 */

// TODO Fix this to not use for context
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}

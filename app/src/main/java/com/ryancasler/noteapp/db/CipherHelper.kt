package com.ryancasler.noteapp.db

import android.content.Context
import com.ryancasler.noteapp.App
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SQLiteOpenHelper

/**
 * Created by Ryan Casler on 4/10/18
 */
// TODO: This App.instance for context is probably bad and a hack to just get to playing with the db
class CipherHelper(context: Context = App.instance) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    init {
        SQLiteDatabase.loadLibs(context)
    }

    val db: SQLiteDatabase
        get() = getWritableDatabase(PASSWORD)

    // TODO: pass in a getWritabeDatabase?
    val map: Map<String, Dao>
        get() = mapOf(
            NoteDao.NAME to NoteDao()
        )

    override fun onCreate(db: SQLiteDatabase) = map.values.forEach { it.create(db) }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) = map.values.forEach { it.update(db, oldVersion, newVersion) }

    companion object {
        private const val DATABASE_NAME = "test"
        private const val DATABASE_VERSION = 1
        private const val PASSWORD = "1234"
        val instance by lazy { CipherHelper() }
    }
}

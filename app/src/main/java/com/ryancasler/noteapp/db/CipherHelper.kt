package com.ryancasler.noteapp.db

import android.content.Context
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SQLiteOpenHelper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ryan Casler on 4/10/18
 */
@Singleton
class CipherHelper @Inject constructor(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    init {
        SQLiteDatabase.loadLibs(context)
    }

    val db: SQLiteDatabase
        get() = getWritableDatabase(PASSWORD)

    val map: Map<String, Dao>
        get() = mapOf(
            NoteDao.NAME to NoteDao(db)
        )

    override fun onCreate(db: SQLiteDatabase) = map.values.forEach { it.create(db) }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) = map.values.forEach { it.update(db, oldVersion, newVersion) }

    companion object {
        private const val DATABASE_NAME = "test"
        private const val DATABASE_VERSION = 1
        private const val PASSWORD = "1234"
    }
}

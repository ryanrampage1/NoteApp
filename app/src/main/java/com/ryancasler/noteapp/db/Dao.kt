package com.ryancasler.noteapp.db

import net.sqlcipher.database.SQLiteDatabase

/**
 * Created by Ryan Casler on 4/10/18
 */
interface Dao {
    fun update(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    fun create(db: SQLiteDatabase)
}

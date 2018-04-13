package com.ryancasler.noteapp.db

import net.sqlcipher.database.SQLiteDatabase

/**
 * Created by Ryan Casler on 4/10/18
 */
abstract class Dao {

    // TODO: This should use Dependency injection instead of a singleton
    val dataBase: SQLiteDatabase
        get() = CipherHelper.instance.db

    abstract fun update(db: SQLiteDatabase, oldVersion: Int, newVersion: Int)
    abstract fun create(db: SQLiteDatabase)
}

package com.ryancasler.noteapp.db

import com.ryancasler.noteapp.model.Note
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import net.sqlcipher.database.SQLiteDatabase

/**
 * Created by Ryan Casler on 4/10/18
 */
class NoteDao constructor(private val database: SQLiteDatabase) : Dao {

    override fun update(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) = TODO("Still on V1")

    override fun create(db: SQLiteDatabase) {
        val create = """
            CREATE TABLE $TABLE_NAME (
                $ID  INTEGER PRIMARY KEY AUTOINCREMENT,
                $TEXT TEXT,
                $AUTHOR TEXT
            )"""

        db.execSQL(create)
    }

    fun addNote(note: String, author: String) = async {
        val insert = """
            INSERT INTO $TABLE_NAME ($TEXT, $AUTHOR)
            VALUES ('$note', '$author')
        """

        database.execSQL(insert)
    }


    fun getNotes() = async(CommonPool) {
        val select = "SELECT * FROM $TABLE_NAME"

        val notes = mutableListOf<Note>()

        val cursor = database.rawQuery(select, null)
        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            cursor.apply {
                notes.add(Note(getInt(0), getString(1), getString(2)))
            }

            cursor.moveToNext()
        }

        cursor.close()
        notes
    }

    companion object {
        const val NAME = "noteDao"
        const val TABLE_NAME = "note"
        const val ID = "id"
        const val TEXT = "text"
        const val AUTHOR = "author"
    }

}

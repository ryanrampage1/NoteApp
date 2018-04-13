package com.ryancasler.noteapp.db

import android.util.Log
import com.ryancasler.noteapp.model.Note
import net.sqlcipher.database.SQLiteDatabase

/**
 * Created by Ryan Casler on 4/10/18
 */
class NoteDao : Dao() {

    override fun update(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Still on V1")
    }

    override fun create(db: SQLiteDatabase) {
        val create = """
            CREATE TABLE $TABLE_NAME (
                $ID  INTEGER PRIMARY KEY AUTOINCREMENT,
                $TEXT TEXT,
                $AUTHOR TEXT
            )"""

        db.execSQL(create)
    }

    fun addNote(note: String, author: String) {
        val insert = """
            INSERT INTO $TABLE_NAME ($TEXT, $AUTHOR)
            VALUES ('$note', '$author')
            """
        val cursor = dataBase.rawQuery(insert, null)

        Log.d("this", cursor.count.toString())
    }

    fun getNotes() : List<Note> {
        val select = """
            SELECT * FROM $TABLE_NAME
            """
        val cursor = dataBase.rawQuery(select, null)

        val notes = mutableListOf<Note>()

        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            cursor.apply {
                notes.add(Note(getInt(0), getString(1), getString(2)))
            }

            cursor.moveToNext()
        }

        cursor.close()

        return notes
    }

    companion object {
        const val NAME = "noteDao"
        const val TABLE_NAME = "note"
        const val ID = "id"
        const val TEXT = "text"
        const val AUTHOR = "author"
    }

}

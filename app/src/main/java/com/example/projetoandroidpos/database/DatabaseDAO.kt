package com.example.projetoandroidpos.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteCursor
import android.database.sqlite.SQLiteDatabase
import com.example.projetoandroidpos.DDCharacter
import com.example.projetoandroidpos.database.Contract.PostEntry


class DatabaseDAO(val databaseHelper: DatabaseHelper) {
    private lateinit var db: SQLiteDatabase

    fun insert(data: DDCharacter) {
        db = databaseHelper.writableDatabase
        val values = ContentValues()
        values.put(PostEntry.COLUMN_NAME, data.name)
        values.put(PostEntry.COLUMN_LEVEL, data.level)
        values.put(PostEntry.COLUMN_CLASS,data.characterClass)

        db.insert(PostEntry.TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun readAll(): MutableList<DDCharacter> {
        db = databaseHelper.readableDatabase
        val projection = arrayOf<String>(
            PostEntry._ID,
            PostEntry.COLUMN_NAME,
            PostEntry.COLUMN_LEVEL,
            PostEntry.COLUMN_CLASS,
        )

        val cursor = db.query(
            PostEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val listOfCharacters: MutableList<DDCharacter> = ArrayList()
        if (cursor.moveToFirst()) {
            val data = getObjectFilled(cursor)
            listOfCharacters.add(data)
            while (cursor.moveToNext()) {
                val data = getObjectFilled(cursor)
                listOfCharacters.add(data)
            }
        }
        cursor.close()
        db.close()
        return listOfCharacters
    }

    @SuppressLint("Range")
    private fun getObjectFilled(cursor: Cursor): DDCharacter {
        val name = cursor.getString(cursor.getColumnIndex(PostEntry.COLUMN_NAME))
        val level = cursor.getString(cursor.getColumnIndex(PostEntry.COLUMN_LEVEL))
        val characterClass = cursor.getString(cursor.getColumnIndex(PostEntry.COLUMN_CLASS))
        return DDCharacter(name, level, characterClass)
    }
}
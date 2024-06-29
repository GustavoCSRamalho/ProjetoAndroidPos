package com.example.projetoandroidpos.database
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_POSTS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_POSTS)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        private const val TEXT_TYPE = " TEXT"
        private const val COMMA_SEP = ","
        private val SQL_CREATE_POSTS =

            ((((("CREATE TABLE " + Contract.PostEntry.TABLE_NAME).toString() + " (" +
                    Contract.PostEntry._ID).toString() + " INTEGER PRIMARY KEY," +
                    Contract.PostEntry.COLUMN_NAME).toString() + TEXT_TYPE + COMMA_SEP +
                    Contract.PostEntry.COLUMN_LEVEL).toString() + TEXT_TYPE + COMMA_SEP +
                    Contract.PostEntry.COLUMN_CLASS).toString() + TEXT_TYPE + " )"

        private val SQL_DELETE_POSTS = "DROP TABLE IF EXISTS " + Contract.PostEntry.TABLE_NAME

        const val DATABASE_VERSION: Int = 1
        const val DATABASE_NAME: String = "d&d.db"
    }
}
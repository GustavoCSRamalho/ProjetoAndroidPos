package com.example.projetoandroidpos.database

import android.provider.BaseColumns

class Contract private constructor() {
    object PostEntry : BaseColumns {
        const val TABLE_NAME: String = "classes"
        const val _ID: String = "id"
        const val COLUMN_NAME: String = "name"
        const val COLUMN_LEVEL: String = "level"
        const val COLUMN_CLASS: String = "characterClass"
    }
}
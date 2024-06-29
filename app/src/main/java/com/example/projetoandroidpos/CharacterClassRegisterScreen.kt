package com.example.projetoandroidpos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoandroidpos.database.DatabaseDAO
import com.example.projetoandroidpos.database.DatabaseHelper

class CharacterClassRegisterScreen : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var databaseDAO: DatabaseDAO

    private lateinit var name: EditText
    private lateinit var level: EditText
    private lateinit var classRadioGroup: RadioGroup
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register_screen)

        databaseHelper = DatabaseHelper(context = this@CharacterClassRegisterScreen)
        databaseDAO = DatabaseDAO(databaseHelper)

        name = findViewById<EditText>(R.id.nameEditTextText)
        level = findViewById<EditText>(R.id.levelEditTextText)
        classRadioGroup = findViewById<RadioGroup>(R.id.classRadioGroup)
        button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val name = name.text.toString()
            val level = level.text.toString()
            val characterClass = getRadioButtonValue()
            val data = DDCharacter(name, level, characterClass)
            databaseDAO.insert(data)
            finish()
        }

    }

    fun getRadioButtonValue(): String {
        var radioButton =  findViewById<RadioButton>(classRadioGroup.getCheckedRadioButtonId())
        return radioButton.getText().toString()
    }
}
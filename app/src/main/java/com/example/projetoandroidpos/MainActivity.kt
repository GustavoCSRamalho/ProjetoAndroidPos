package com.example.projetoandroidpos

import android.R.attr.value
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidpos.database.DatabaseDAO
import com.example.projetoandroidpos.database.DatabaseHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var databaseDAO: DatabaseDAO
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: FloatingActionButton
    private lateinit var adapter: RecyclerViewAdapter

    override fun onResume() {
        super.onResume()
        val list = databaseDAO.readAll()
        adapter.listOfCharacterClass = list
        adapter.notifyDataSetChanged();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseHelper = DatabaseHelper(context = this@MainActivity)
        databaseDAO = DatabaseDAO(databaseHelper)
        setContentView(R.layout.activity_main)


        button = findViewById<FloatingActionButton>(R.id.buttonChangePage)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = RecyclerViewAdapter(listOfCharacterClass = arrayListOf(
            DDCharacter("nome 1","2","teste"),
            DDCharacter("nome 1","2","teste"))
        )
        recyclerView.adapter = adapter

        button.setOnClickListener {
            val myIntent: Intent = Intent(
                this@MainActivity,
                CharacterClassRegisterScreen::class.java
            )
            startActivity(myIntent)
        }
    }
}
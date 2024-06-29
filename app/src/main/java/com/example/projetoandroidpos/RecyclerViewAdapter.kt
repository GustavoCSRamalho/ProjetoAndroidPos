package com.example.projetoandroidpos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var listOfCharacterClass: MutableList<DDCharacter>): RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characterclass, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = listOfCharacterClass.count()

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {
        viewHolder.bind(listOfCharacterClass.get(position))
    }

    inner class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val nameTextView = view.findViewById<TextView>(R.id.name)
        private val levelTextView = view.findViewById<TextView>(R.id.level)
        private val characterClassTextView = view.findViewById<TextView>(R.id.characterClass)

        fun bind(character: DDCharacter) {
            nameTextView.text = character.name
            levelTextView.text = character.level
            characterClassTextView.text = character.characterClass
        }
    }
}
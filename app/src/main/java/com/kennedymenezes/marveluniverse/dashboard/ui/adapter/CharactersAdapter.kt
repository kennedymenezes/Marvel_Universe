package com.kennedymenezes.marveluniverse.dashboard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kennedymenezes.marveluniverse.R
import com.kennedymenezes.marveluniverse.dashboard.data.model.CharactersResultResponse
import com.kennedymenezes.marveluniverse.databinding.ItemCharacterBinding

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private val charactersList = mutableListOf<CharactersResultResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        charactersList[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    fun loadCharacters(newCharacters: List<CharactersResultResponse>){
        charactersList.addAll(newCharacters)
        notifyDataSetChanged()
    }

    inner class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemCharacterBinding.bind(itemView)

        fun bind(charactersResultResponse: CharactersResultResponse){
            binding.tvCharacterName.text = charactersResultResponse.name
            Glide.with(binding.root).load(charactersResultResponse.getHeroImg()).into(binding.ivCharacterImg)
        }
    }

}
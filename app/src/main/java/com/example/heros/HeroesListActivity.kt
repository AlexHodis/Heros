package com.example.heros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heros.databinding.ActivityHeroesDetailBinding
import com.example.heros.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHeroesListBinding
    lateinit var adapter: HeroAdapter

    companion object{}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_list)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }

        val gson = Gson()
        val type = object : TypeToken<List<Hero>>() { }.type
        val heroes = gson.fromJson<List<Hero>>(jsonText, type)

        adapter = HeroAdapter(heroes)
        binding.recyclerViewHeroesList.adapter = adapter
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)


    }
}
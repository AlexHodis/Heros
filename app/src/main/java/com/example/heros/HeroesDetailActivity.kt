package com.example.heros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heros.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHeroesDetailBinding

    companion object{
        val EXTRA_HERO = "The hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_detail)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

            //extract out Hero object from the intent
        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)
        //put each field of the Hero object into the respecitve widgets
        binding.textViewHerosdetailHero.text = hero?.name
        binding.imageViewHerodetail.setImageDrawable(
            getDrawable(resources.getIdentifier(hero?.image, "drawable", packageName))
        )
        binding.textViewHerodetailDesc.text = hero?.description
        binding.textViewHerodetailRanking.text = hero?.ranking.toString()
        binding.textViewHerodetailSuperpower.text = hero?.superpower
    }
}
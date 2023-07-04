package com.bojanmandic.cheersApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CocktailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_layout)

        val cocktailName = findViewById<TextView>(R.id.cocktailName)
        val cocktailType = findViewById<TextView>(R.id.cocktailType)
        val cocktailIngredience = findViewById<TextView>(R.id.cocktailIngredience)
        val cocktailInstructions = findViewById<TextView>(R.id.cocktailInstructions)
        val cocktailImage = findViewById<ImageView>(R.id.cocktailImage)

        cocktailName.text = intent.getStringExtra("name")
        cocktailType.text = intent.getStringExtra("type")
        cocktailIngredience.text = intent.getStringExtra("ingredients")
        cocktailInstructions.text = intent.getStringExtra("instructions")

        Glide.with(this)
            .load(intent.getStringExtra("image"))
            .into(cocktailImage)
    }
}
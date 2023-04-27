package com.example.makeyocoffee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Recipes_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_list)

        val btn = findViewById<Button>(R.id.buttonShow)
        btn.setOnClickListener {
            val intent = Intent(this, Recipe_view::class.java)
            startActivity(intent)
        }
    }
}
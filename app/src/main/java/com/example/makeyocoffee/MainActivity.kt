package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.makeyocoffee.recipes.RecipesList


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //словари хранят значения чекбоксов
        var grinding =
            hashMapOf<String, Int>("FINE" to 0, "MEDIUM" to 0, "LARGE" to 0)
        var roasting = hashMapOf<String, Int>("MEDIUM" to 0, "DARK" to 0) //filter, espresso
        var devices = hashMapOf<String, Int>(
            "CEZVE" to 0, "COFFEE_MACHINE" to 0, "GEYSER" to 0, "V60" to 0,
            "AEROPRESS" to 0, "CHEMEX" to 0, "FRENCH_PRESS" to 0
        )

        val btn = findViewById<Button>(R.id.buttonNext)
        val cbFineGrinding: Button = findViewById(R.id.checkBox_smallGrinding)
        val cbMediumGrinding: Button = findViewById(R.id.checkBox_mediumGrinding)
        val cbLargeGrinding: Button = findViewById(R.id.checkBox_largeGrinding)
        val cbDarkRoasting: Button = findViewById(R.id.checkBox_espressoRoast)
        val cbMediumRoasting: Button = findViewById(R.id.checkBox_filterRoast)
        val cbCoffeeMachine: Button = findViewById(R.id.checkBox_coffeMachine)
        val cbCezve: Button = findViewById(R.id.checkBox_cezve)
        val cbFrenchPress: Button = findViewById(R.id.checkBox_frenchPress)
        val cbV60: Button = findViewById(R.id.checkBox_V60)
        val archiveButton = findViewById<Button>(R.id.toArchiveButton)
        val articlesListButton = findViewById<Button>(R.id.toArticlesListButton)


        btn.setOnClickListener {
            val intent = Intent(this, RecipesList::class.java)

            val checkedGrinding = ArrayList(grinding.filterValues { it == 1 }.keys)
            intent.putStringArrayListExtra("grindingList", checkedGrinding)

            val checkedRoasting = ArrayList(roasting.filterValues { it == 1 }.keys)
            intent.putStringArrayListExtra("roastingList", checkedRoasting)

            val checkedDevices = ArrayList(devices.filterValues { it == 1 }.keys)
            intent.putStringArrayListExtra("devicesList", checkedDevices)

            startActivity(intent)
        }

        archiveButton.setOnClickListener {
            val intent = Intent(this, ArticleView::class.java)
            startActivity(intent)
        }

        articlesListButton.setOnClickListener {
            val intent = Intent(this, ArticlesList::class.java)
            startActivity(intent)
        }

        //чекбоксы на помол
        cbFineGrinding.setOnClickListener {
            if (grinding["FINE"] == 0) {
                grinding["FINE"] = 1
                Log.d("checkbox", "small grinding 1")
            } else {
                grinding["FINE"] = 0
                Log.d("checkbox", "small grinding 0")
            }
        }
        cbMediumGrinding.setOnClickListener {
            if (grinding["MEDIUM"] == 0) {
                grinding["MEDIUM"] = 1
                Log.d("checkbox", "medium grinding 1")
            } else {
                grinding["MEDIUM"] = 0
                Log.d("checkbox", "medium grinding 0")
            }
        }
        cbLargeGrinding.setOnClickListener {
            if (grinding["LARGE"] == 0) {
                grinding["LARGE"] = 1
                Log.d("checkbox", "large grinding 1")
            } else {
                grinding["LARGE"] = 0
                Log.d("checkbox", "large grinding 0")
            }
        }


        //чекбоксы на обжарку
        cbDarkRoasting.setOnClickListener {
            if (roasting["DARK"] == 0) {
                roasting["DARK"] = 1
                Log.d("checkbox", "espresso roast 1")
            } else {
                roasting["DARK"] = 0
                Log.d("checkbox", "espresso roast 0")
            }
        }
        cbMediumRoasting.setOnClickListener {
            if (roasting["MEDIUM"] == 0) {
                roasting["MEDIUM"] = 1
                Log.d("checkbox", "filter roast 1")
            } else {
                roasting["MEDIUM"] = 0
                Log.d("checkbox", "filter roast 0")
            }
        }


        //чекбоксы на способы приготовления
        cbCoffeeMachine.setOnClickListener {
            if (devices["COFFEE_MACHINE"] == 0) {
                devices["COFFEE_MACHINE"] = 1
                Log.d("checkbox", "coffee machine 1")
            } else {
                devices["COFFEE_MACHINE"] = 0
                Log.d("checkbox", "coffee machine 0")
            }
        }
        cbCezve.setOnClickListener {
            if (devices["CEZVE"] == 0) {
                devices["CEZVE"] = 1
                Log.d("checkbox", "cezve 1")
            } else {
                devices["CEZVE"] = 0
                Log.d("checkbox", "cezve 0")
            }
        }
        cbFrenchPress.setOnClickListener {
            if (devices["FRENCH_PRESS"] == 0) {
                devices["FRENCH_PRESS"] = 1
                Log.d("checkbox", "french press ")
            } else {
                devices["FRENCH_PRESS"] = 0
                Log.d("checkbox", "french press 0")
            }
        }
        cbV60.setOnClickListener {
            if (devices["V60"] == 0) {
                devices["V60"] = 1
                Log.d("checkbox", "v60 1")
            } else {
                devices["V60"] = 0
                Log.d("checkbox", "v60 0")
            }
        }
    }

}
package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.recipes.FavouriteRecipes
import com.example.makeyocoffee.recipes.RecipesList
import com.example.makeyocoffee.repository.DeviceRepository
import com.example.makeyocoffee.repository.UserDeviceRepository


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //словари хранят значения чекбоксов
        val grinding = hashMapOf("FINE" to 0, "MEDIUM" to 0, "LARGE" to 0)
        val roasting = hashMapOf("MEDIUM" to 0, "DARK" to 0) //filter, espresso
        val devices = hashMapOf(
            "CEZVE" to 0, "COFFEE_MACHINE" to 0, "GEYSER" to 0, "V60" to 0,
            "AEROPRESS" to 0, "CHEMEX" to 0, "FRENCH_PRESS" to 0
        )
        val db = AppDatabase.getDatabase(this)
        val userDeviceRepo = UserDeviceRepository(db.userDeviceDao())

        val btn = findViewById<Button>(R.id.buttonNext)
        val cbFineGrinding: Button = findViewById(R.id.checkBox_smallGrinding)
        val cbMediumGrinding: Button = findViewById(R.id.checkBox_mediumGrinding)
        val cbLargeGrinding: Button = findViewById(R.id.checkBox_largeGrinding)
        val cbDarkRoasting: Button = findViewById(R.id.checkBox_espressoRoast)
        val cbMediumRoasting: Button = findViewById(R.id.checkBox_filterRoast)
        val cbCoffeeMachine: CheckBox = findViewById(R.id.checkBox_coffeMachine)
        val cbCezve: CheckBox = findViewById(R.id.checkBox_cezve)
        val cbFrenchPress: CheckBox = findViewById(R.id.checkBox_frenchPress)
        val cbV60: CheckBox = findViewById(R.id.checkBox_V60)
        val cbGeyser: CheckBox = findViewById(R.id.checkBoxGeyser)
        val cbChemex: CheckBox = findViewById(R.id.checkBoxChemex)
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

            val deviceRepo = DeviceRepository(db.deviceDao())
            val deviceIds = deviceRepo.getDevicesByName(checkedDevices)
            userDeviceRepo.updateDevices(deviceIds)

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
        cbGeyser.setOnClickListener{
            if (devices["GEYSER"] == 0){
                devices["GEYSER"] = 1
            } else{
                devices["GEYSER"] = 0
            }
        }
        cbChemex.setOnClickListener{
            if (devices["CHEMEX"] == 0){
                devices["CHEMEX"] = 1
            } else{
                devices["CHEMEX"] = 0
            }
        }
        val favouriteBtn = findViewById<Button>(R.id.favouriteRecipesButton)
        favouriteBtn.setOnClickListener {
            val intent = Intent(this, FavouriteRecipes::class.java)
            startActivity(intent)
        }

        val previousDevices = userDeviceRepo.getDevices()
        previousDevices.forEach {
            devices[it] = 1
            when (it) {
                "COFFEE_MACHINE" -> cbCoffeeMachine.isChecked = true
                "CEZVE" -> cbCezve.isChecked = true
                "FRENCH_PRESS" -> cbFrenchPress.isChecked = true
                "V60" -> cbV60.isChecked = true
                "GEYSER" -> cbGeyser.isChecked = true
                "CHEMEX" -> cbChemex.isChecked = true
            }
        }
    }

}
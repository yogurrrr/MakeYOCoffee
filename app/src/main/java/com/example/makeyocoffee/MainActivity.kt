package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.makeyocoffee.databinding.ActivityMainBinding
import com.example.makeyocoffee.database.AppDatabase


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //массивы хранят значения чекбоксов
        var grinding_array : IntArray = intArrayOf(0,0,0) //small, medium, large
        var roast_array : IntArray = intArrayOf(0,0) //espresso, filter
        var devices : IntArray = intArrayOf(0,0,0,0) //coffee machine, cezve, french press, V60

        val btn = findViewById<Button>(R.id.buttonNext)
        val cb_small_grinding : Button = findViewById(R.id.checkBox_smallGrinding)
        val cb_medium_grinding : Button = findViewById(R.id.checkBox_mediumGrinding)
        val cb_large_grinding : Button = findViewById(R.id.checkBox_largeGrinding)
        val cb_espresso_roast : Button = findViewById(R.id.checkBox_espressoRoast)
        val cb_filter_roast : Button = findViewById(R.id.checkBox_filterRoast)
        val cb_coffee_machine : Button = findViewById(R.id.checkBox_coffeMachine)
        val cb_cezve : Button = findViewById(R.id.checkBox_cezve)
        val cb_french_press : Button = findViewById(R.id.checkBox_frenchPress)
        val cb_v60 : Button = findViewById(R.id.checkBox_V60)


        btn.setOnClickListener {
            val intent = Intent(this, Recipes_list::class.java)
            startActivity(intent)
        }


        //чекбоксы на помол
        cb_small_grinding.setOnClickListener{
            if (grinding_array[0] == 0){
                grinding_array[0] = 1
                Log.d("checkbox", "small grinding 1")
            }
            else{
                grinding_array[0] = 0
                Log.d("checkbox", "small grinding 0")
            }
        }
        cb_medium_grinding.setOnClickListener{
            if (grinding_array[1] == 0){
                grinding_array[1] = 1
                Log.d("checkbox", "medium grinding 1")
            }
            else{
                grinding_array[1] = 0
                Log.d("checkbox", "medium grinding 0")
            }
        }
        cb_large_grinding.setOnClickListener{
            if (grinding_array[2] == 0){
                grinding_array[2] = 1
                Log.d("checkbox", "large grinding 1")
            }
            else{
                grinding_array[2] = 0
                Log.d("checkbox", "large grinding 0")
            }
        }


        //чекбоксы на обжарку
        cb_espresso_roast.setOnClickListener{
            if (roast_array[0] == 0){
                roast_array[0] = 1
                Log.d("checkbox", "espresso roast 1")
            }
            else{
                roast_array[0] = 0
                Log.d("checkbox", "espresso roast 0")
            }
        }
        cb_filter_roast.setOnClickListener{
            if (roast_array[1] == 0){
                roast_array[1] = 1
                Log.d("checkbox", "filter roast 1")
            }
            else{
                roast_array[1] = 0
                Log.d("checkbox", "filter roast 0")
            }
        }



        //чекбоксы на способы приготовления
        cb_coffee_machine.setOnClickListener{
            if (devices[0] == 0){
                devices[0] = 1
                Log.d("checkbox", "coffee machine 1")
            }
            else{
                devices[0] = 0
                Log.d("checkbox", "coffee machine 0")
            }
        }
        cb_cezve.setOnClickListener{
            if (devices[1] == 0){
                devices[1] = 1
                Log.d("checkbox", "cezve 1")
            }
            else{
                devices[1] = 0
                Log.d("checkbox", "cezve 0")
            }
        }
        cb_french_press.setOnClickListener{
            if (devices[2] == 0){
                devices[2] = 1
                Log.d("checkbox", "french press ")
            }
            else{
                devices[2] = 0
                Log.d("checkbox", "french press 0")
            }
        }
        cb_v60.setOnClickListener{
            if (devices[3] == 0){
                devices[3] = 1
                Log.d("checkbox", "v60 1")
            }
            else{
                devices[3] = 0
                Log.d("checkbox", "v60 0")
            }
        }
    }

}
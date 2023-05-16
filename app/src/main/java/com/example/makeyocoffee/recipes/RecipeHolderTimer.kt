package com.example.makeyocoffee.recipes

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.makeyocoffee.R

/**
 * A simple [Fragment] subclass.
 * Use the [RecipeHolderTimer.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecipeHolderTimer : Fragment() {
    private var param1: Int? = null
    private lateinit var timerTextView: TextView
    private lateinit var titletimer: TextView
    private lateinit var startButton: Button
    private lateinit var timer: CountDownTimer
    private lateinit var isV60: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt("position")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_recipe_holder_timer, container, false)

        val title: TextView = view.findViewById(R.id.title)
        val ingredients: TextView = view.findViewById(R.id.ingredients)
        val instructions: TextView = view.findViewById(R.id.instructions)
        var timerIsOn: Boolean = false

        timerTextView = view.findViewById(R.id.timer)
        startButton = view.findViewById(R.id.buttonTimer)
        titletimer = view.findViewById(R.id.timerTitile)



        title.text = arguments?.getString("title")
        ingredients.text = arguments?.getString("ingredients")
        instructions.text = arguments?.getString("instructions")
        var time: Long = 60000
        if (title.text == "Кофе в чашке"){
            time = 180000
            timerTextView.text = "3:00"
        }
        else if (title.text == "Кофе во френч - прессе"){
            time = 300000
            timerTextView.text = "5:00"
        }
        else if(title.text == "Кофе V60"){
            time = 20000
            isV60 ="1"
            timerTextView.text = "00:20"
        }

        startButton.setOnClickListener {
            if (timerTextView.text == "00:00"){
                timerIsOn = false
            }
            if (timerIsOn == false){
                if(title.text == "Кофе V60"){ isV60 ="1"}
                startTimer(time)
                timerIsOn = true
            }


        }



        // Inflate the layout for this fragment
        return view//inflater.inflate(R.layout.fragment_recipe_holder_timer, container, false)
    }
    private fun startTimer(time: Long) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var seconds = millisUntilFinished / 1000
                timerTextView.text = String.format("%02d:%02d", seconds / 60, seconds % 60)

            }

            override fun onFinish() {
                timerTextView.text = "00:00"
                val time: Long
                if(isV60 == "1"){
                    time = 10000
                    isV60 = "2"
                    titletimer.text = "Подождите"
                    startTimer(time)
                }
                else if (isV60 == "2"){
                    time = 30000
                    isV60 = "3"
                    titletimer.text = "Пролейте"
                    startTimer(time)
                }
                else if (isV60 == "3"){
                    time = 15000
                    isV60 = "4"
                    titletimer.text = "Подождите"
                    startTimer(time)
                }
                else if (isV60 == "4"){
                    time = 30000
                    isV60 = "0"
                    titletimer.text = "Пролейте"
                    startTimer(time)
                    titletimer.text = "Таймер"
                }

            }
        }
        timer.start()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        if (::timer.isInitialized) {
            timer.cancel()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecipeHolderTimer.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            RecipeHolderTimer().apply {
                arguments = Bundle().apply {
                    putInt("position", param1)
                }
            }
    }
}
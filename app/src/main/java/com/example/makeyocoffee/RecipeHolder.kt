package com.example.makeyocoffee


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RecipeHolder : Fragment() {
    private var param1: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt("position")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_recipe_holder, container, false)

        val title: TextView = view.findViewById(R.id.title)
        val ingredients: TextView = view.findViewById(R.id.ingredients)
        val instructions: TextView = view.findViewById(R.id.instructions)

//        val db = activity?.let { AppDatabase.getDatabase(it.applicationContext) }
//        val recipeRepo = db?.let { RecipeRepository(it.recipeDao()) }
//        val recipes = recipeRepo?.getAllRecipes()

        title.text = arguments?.getString("title")
        ingredients.text = arguments?.getString("ingredients")
        instructions.text = arguments?.getString("instructions")
//        val position = arguments?.getInt("position")
//        if (position != null) {
//            val recipe = position.let { recipes?.get(it) }
//            if (recipe != null) {
//                title.text = recipe.name
//                ingredients.text = recipe.ingredients
//                instructions.text = recipe.description
//            }
//        }


        // Inflate the layout for this fragment
        return view//inflater.inflate(R.layout.fragment_recipe_holder, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecipeHolder.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            RecipeHolder().apply {
                arguments = Bundle().apply {
                    putInt("position", param1)
                }
            }
    }
}
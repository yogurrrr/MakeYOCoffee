package com.example.makeyocoffee


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.repository.LikeRepository

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
        val image: ImageView = view.findViewById(R.id.image)
        val likeBtn: ImageView = view.findViewById(R.id.like)

        val bundle: Bundle? = arguments
        var likeVal = 0
        var recipeId = 0
        if (bundle != null) {
            recipeId = bundle.getInt("id")
            title.text = bundle.getString("title")
            ingredients.text = bundle.getString("ingredients")
            instructions.text = bundle.getString("instructions")
            val imagePath = bundle.getString("image_path")
            val imageId = resources.getIdentifier(imagePath, "drawable", context!!.packageName)
            image.setImageResource(imageId)
            likeVal = bundle.getInt("like")
            if (likeVal == 1) {
                likeBtn.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.heart_filled))
            }
        }

        val db = AppDatabase.getDatabase(requireContext())
        val likeRepo = LikeRepository(db.likeDao())

        likeBtn.setOnClickListener {
            if (likeVal == 1) {
                likeBtn.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.heart))
                likeRepo.deleteLike(recipeId)
            }
            else {
                likeBtn.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.heart_filled))
                likeRepo.addLike(recipeId)
            }
        }

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
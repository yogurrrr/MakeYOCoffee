package com.example.makeyocoffee.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.R
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.entity.Recipe
import com.example.makeyocoffee.repository.LikeRepository

class RecipeAdapter(context: Context) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private var context: Context

    init {
        this.context = context
    }

    private var recipesList = emptyList<Recipe>()

    interface OnClickListener {
        fun onClick(position: Int, model: Recipe)
    }

    private var onClickListener: OnClickListener? = null

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipesList[position]
        holder.itemView.findViewById<TextView>(R.id.recipeName).text = recipe.name
        holder.itemView.findViewById<TextView>(R.id.recipeShortDescription).text =
            recipe.shortDescription
        holder.itemView.findViewById<TextView>(R.id.recipeIngredients).text =
            recipe.ingredients
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, recipe)
            }
        }

        val likeBtn = holder.itemView.findViewById<ImageView>(R.id.recipeLike)
        if (recipe.like == 1) {
            likeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heart_filled))
        }
        else {
            likeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heart))
        }

        val db = AppDatabase.getDatabase(context)
        val likeRepo = LikeRepository(db.likeDao())

        likeBtn.setOnClickListener {
            if (recipe.like == 1) {
                likeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heart))
                recipe.like = 0
                likeRepo.deleteLike(recipe.recipe_id)
            }
            else {
                likeBtn.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.heart_filled))
                recipe.like = 1
                likeRepo.addLike(recipe.recipe_id)
            }
        }
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }


    fun setData(recipes: List<Recipe>) {
        this.recipesList = recipes
        notifyDataSetChanged()
    }
}
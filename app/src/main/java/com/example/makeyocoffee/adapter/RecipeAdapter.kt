package com.example.makeyocoffee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.R
import com.example.makeyocoffee.entity.Recipe

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private var recipesList = emptyList<Recipe>()

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).
            inflate(R.layout.recipe_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipesList[position]
        holder.itemView.findViewById<TextView>(R.id.recipeName).text = recipe.name
        holder.itemView.findViewById<TextView>(R.id.recipeShortDescription).text =
            recipe.shortDescription
        holder.itemView.findViewById<TextView>(R.id.recipeIngredients).text =
            recipe.ingredients

    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    fun setData(recipes: List<Recipe>) {
        this.recipesList = recipes
        notifyDataSetChanged()
    }
}
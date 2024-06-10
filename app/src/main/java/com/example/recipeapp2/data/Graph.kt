package com.example.recipeapp2.data

import android.content.Context
import androidx.room.Room

object Graph {

    lateinit var database: RecipeDatabase

    val savedRecipeRepository by lazy {
        SavedRecipeRepository(recipeDao = database.recipeDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context = context, RecipeDatabase::class.java,
            name = "savedRecipes.db").build()
    }


}
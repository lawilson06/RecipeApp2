package com.example.recipeapp2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SavedRecipe::class],
    version = 1,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao() : RecipeDao

}
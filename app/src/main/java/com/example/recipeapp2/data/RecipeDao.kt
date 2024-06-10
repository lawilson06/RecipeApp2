package com.example.recipeapp2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addRecipeItem(savedRecipeEntity : SavedRecipe)

    @Query("SELECT * FROM `Recipe-table`")
    abstract fun getSavedRecipeList() : Flow<List<SavedRecipe>>


    @Delete
    abstract fun deleteRecipeItem(savedRecipeEntity: SavedRecipe)

}
package com.example.recipeapp2.data


class SavedRecipeRepository(private val recipeDao: RecipeDao) {

    fun getSavedRecipeList() = recipeDao.getSavedRecipeList()

    fun addRecipe(savedRecipe : SavedRecipe) {
        recipeDao.addRecipeItem(savedRecipe)
    }

    fun deleteRecipe(savedRecipe: SavedRecipe) {
        recipeDao.deleteRecipeItem(savedRecipe)
    }


}
package com.example.recipeapp2.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SavedRecipeViewModel(
    private val savedRecipeRepository : SavedRecipeRepository = Graph.savedRecipeRepository
) : ViewModel() {

    lateinit var getSavedRecipeList : Flow<List<SavedRecipe>>

    init {
        viewModelScope.launch {
            getSavedRecipeList = savedRecipeRepository.getSavedRecipeList()
        }
    }

    fun addRecipeItem(savedRecipe: SavedRecipe) {
        viewModelScope.launch(Dispatchers.IO) {
            savedRecipeRepository.addRecipe(savedRecipe)
        }
    }

    fun deleteRecipeItem(savedRecipe: SavedRecipe) {
        viewModelScope.launch(Dispatchers.IO) {
            savedRecipeRepository.deleteRecipe(savedRecipe)
            getSavedRecipeList = savedRecipeRepository.getSavedRecipeList()
        }
    }


}
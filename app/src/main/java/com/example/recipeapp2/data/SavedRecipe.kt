package com.example.recipeapp2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Recipe-table")
data class SavedRecipe(
    @PrimaryKey(autoGenerate = true)
    var recipeNo: Int = 0,
    @ColumnInfo(name="RecipeName")
    var recipeName: String,
    @ColumnInfo(name="RecipeImage")
    var recipeImage: String,
    @ColumnInfo(name="RecipeCategory")
    var recipeCategory: String,
    @ColumnInfo(name="RecipeIngredient1")
    var recipeIngredient1: String,
    @ColumnInfo(name="RecipeIngredient2")
    var recipeIngredient2: String,
    @ColumnInfo(name="RecipeIngredient3")
    var recipeIngredient3: String,
    @ColumnInfo(name="RecipeIngredient4")
    var recipeIngredient4: String,
    @ColumnInfo(name="RecipeIngredient5")
    var recipeIngredient5: String,
    @ColumnInfo(name="RecipeIngredient6")
    var recipeIngredient6: String,
    @ColumnInfo(name="RecipeIngredient7")
    var recipeIngredient7: String,
    @ColumnInfo(name="RecipeIngredient8")
    var recipeIngredient8: String,
    @ColumnInfo(name="RecipeIngredient9")
    var recipeIngredient9: String,
    @ColumnInfo(name="RecipeIngredient10")
    var recipeIngredient10: String,
    @ColumnInfo(name="RecipeIngredient11")
    var recipeIngredient11: String,
    @ColumnInfo(name="RecipeIngredient12")
    var recipeIngredient12: String,
    @ColumnInfo(name="RecipeIngredient13")
    var recipeIngredient13: String,
    @ColumnInfo(name="RecipeIngredient14")
    var recipeIngredient14: String,
    @ColumnInfo(name="RecipeIngredient15")
    var recipeIngredient15: String,
    @ColumnInfo(name="RecipeIngredient16")
    var recipeIngredient16: String,
    @ColumnInfo(name="RecipeIngredient17")
    var recipeIngredient17: String,
    @ColumnInfo(name="RecipeIngredient18")
    var recipeIngredient18: String,
    @ColumnInfo(name="RecipeIngredient19")
    var recipeIngredient19: String,
    @ColumnInfo(name="RecipeIngredient20")
    var recipeIngredient20: String,
    @ColumnInfo(name="RecipeMeasure1")
    var recipeMeasure1: String,
    @ColumnInfo(name="RecipeMeasure2")
    var recipeMeasure2: String,
    @ColumnInfo(name="RecipeMeasure3")
    var recipeMeasure3: String,
    @ColumnInfo(name="RecipeMeasure4")
    var recipeMeasure4: String,
    @ColumnInfo(name="RecipeMeasure5")
    var recipeMeasure5: String,
    @ColumnInfo(name="RecipeMeasure6")
    var recipeMeasure6: String,
    @ColumnInfo(name="RecipeMeasure7")
    var recipeMeasure7: String,
    @ColumnInfo(name="RecipeMeasure8")
    var recipeMeasure8: String,
    @ColumnInfo(name="RecipeMeasure9")
    var recipeMeasure9: String,
    @ColumnInfo(name="RecipeMeasure10")
    var recipeMeasure10: String,
    @ColumnInfo(name="RecipeMeasure11")
    var recipeMeasure11: String,
    @ColumnInfo(name="RecipeMeasure12")
    var recipeMeasure12: String,
    @ColumnInfo(name="RecipeMeasure13")
    var recipeMeasure13: String,
    @ColumnInfo(name="RecipeMeasure14")
    var recipeMeasure14: String,
    @ColumnInfo(name="RecipeMeasure15")
    var recipeMeasure15: String,
    @ColumnInfo(name="RecipeMeasure16")
    var recipeMeasure16: String,
    @ColumnInfo(name="RecipeMeasure17")
    var recipeMeasure17: String,
    @ColumnInfo(name="RecipeMeasure18")
    var recipeMeasure18: String,
    @ColumnInfo(name="RecipeMeasure19")
    var recipeMeasure19: String,
    @ColumnInfo(name="RecipeMeasure20")
    var recipeMeasure20: String,
    @ColumnInfo(name="RecipeInstructions")
    var recipeInstructions: String

)

package com.example.recipeapp2.data

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.recipeapp2.MealsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedRecipeScreen(navController: NavController, viewModel: SavedRecipeViewModel) {
    val savedRecipeList = viewModel.getSavedRecipeList.collectAsState(initial = listOf())
    Log.d("TAG_SAVED_RECIPES", savedRecipeList.toString())
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.navigate(MealsScreen.CategoriesScreen.route) }) {
                    Icon(imageVector = Icons.TwoTone.AccountBox, contentDescription = "Top Bar Icon")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                titleContentColor = MaterialTheme.colorScheme.tertiary,
            ),
            title = {
                Text("My Recipes")
            }
        )
    },
        floatingActionButton = {
            FloatingActionButton(onClick = {
            navController.navigate(MealsScreen.CategoriesScreen.route)
        },
            modifier = Modifier.padding(all = 25.dp),
            contentColor = Color.Black,
            containerColor = Color.White) {
            Icon(imageVector = Icons.TwoTone.Search, contentDescription = null)

        }
        }
    ) {
        LazyVerticalGrid(modifier = Modifier.padding(it), columns = GridCells.Fixed(2)) {
            items(savedRecipeList.value, key = { recipe -> recipe.recipeNo }) { recipe ->
                SavedRecipeItem(
                    savedRecipe = recipe, viewModel
                )
            }
        }
    }


}

@Composable
fun SavedRecipeItem(savedRecipe: SavedRecipe, viewModel: SavedRecipeViewModel) {
    var recipeDetails by remember { mutableStateOf(false) }
    val recipeText = TextStyle(
        fontFamily = FontFamily.Cursive,
        fontSize = 22.sp,
        color = Color.Black
    )

    val ingredientsText1 = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 20.sp,
        color = Color.White
    )

    val ingredientsText2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 15.sp,
        color = Color.White
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
            .clickable { recipeDetails = true }) {
        Column() {
            Text(text = savedRecipe.recipeName, style = recipeText, minLines = 2)
            Row() {
                AsyncImage(
                    model = savedRecipe.recipeImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(88.dp)
                        .padding(4.dp)
                )

            }

        }
        if (recipeDetails) {
            AlertDialog(onDismissRequest = { recipeDetails = false },
                confirmButton = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Recipe Ingredients", style = ingredientsText1)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(savedRecipe.recipeName, style = ingredientsText2)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("[${savedRecipe.recipeCategory}]", style = ingredientsText2)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("${savedRecipe.recipeMeasure1} ${savedRecipe.recipeIngredient1}")
                        Text("${savedRecipe.recipeMeasure2} ${savedRecipe.recipeIngredient2}")
                        Text("${savedRecipe.recipeMeasure3} ${savedRecipe.recipeIngredient3}")
                        Text("${savedRecipe.recipeMeasure4} ${savedRecipe.recipeIngredient4}")
                        Text("${savedRecipe.recipeMeasure5} ${savedRecipe.recipeIngredient5}")
                        Text("${savedRecipe.recipeMeasure6} ${savedRecipe.recipeIngredient6}")
                        Text("${savedRecipe.recipeMeasure7} ${savedRecipe.recipeIngredient7}")
                        Text("${savedRecipe.recipeMeasure8} ${savedRecipe.recipeIngredient8}")
                        Text("${savedRecipe.recipeMeasure9} ${savedRecipe.recipeIngredient9}")
                        Text("${savedRecipe.recipeMeasure10} ${savedRecipe.recipeIngredient10}")
                        Text("${savedRecipe.recipeMeasure11} ${savedRecipe.recipeIngredient11}")
                        Text("${savedRecipe.recipeMeasure12} ${savedRecipe.recipeIngredient12}")
                        Text("${savedRecipe.recipeMeasure13} ${savedRecipe.recipeIngredient13}")
                        Text("${savedRecipe.recipeMeasure14} ${savedRecipe.recipeIngredient14}")
                        Text("${savedRecipe.recipeMeasure15} ${savedRecipe.recipeIngredient15}")
                        Text("${savedRecipe.recipeMeasure16} ${savedRecipe.recipeIngredient16}")
                        Text("${savedRecipe.recipeMeasure17} ${savedRecipe.recipeIngredient17}")
                        Text("${savedRecipe.recipeMeasure18} ${savedRecipe.recipeIngredient18}")
                        Text("${savedRecipe.recipeMeasure19} ${savedRecipe.recipeIngredient19}")
                        Text("${savedRecipe.recipeMeasure20} ${savedRecipe.recipeIngredient20}")

                        Row(
                            modifier = Modifier.align(
                                Alignment.CenterHorizontally
                            )
                        ) {
                            Button(onClick = {
                                recipeDetails = false
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowBack,
                                    contentDescription = "dismiss"
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Button(onClick = {
                                viewModel.deleteRecipeItem(savedRecipe)
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Delete,
                                    contentDescription = "delete"
                                )
                            }
                        }

                    }
                })
        }
    }
}





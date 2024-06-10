package com.example.recipeapp2.details


import android.util.Log
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.recipeapp2.MealsScreen
import com.example.recipeapp2.data.SavedRecipe
import com.example.recipeapp2.data.SavedRecipeViewModel
import com.example.recipeapp2.model.response.MealDetailsResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsDetailsScreen(details : String, viewModel: MealDetailsViewModel, navController: NavController, savedRecipeViewModel: SavedRecipeViewModel) {

    val rememberedDetails = remember { mutableStateOf(emptyList<MealDetailsResponse>())}
    val context = LocalContext.current

    viewModel.getDetails(successCallback = {
            response ->
        rememberedDetails.value = response?.details.orEmpty()
    }, c= details)
    Log.d("TAG_MEAL_ID", details)
    Log.d("TAG_DETAILS_RESPONSE", rememberedDetails.value.toString())

    var recipeName :String = ""
    var recipeImage: String = ""
    var recipeCategory: String = ""
    var recipeIngredient1: String = ""
    var recipeIngredient2: String = ""
    var recipeIngredient3: String = ""
    var recipeIngredient4: String = ""
    var recipeIngredient5: String = ""
    var recipeIngredient6: String = ""
    var recipeIngredient7: String = ""
    var recipeIngredient8: String = ""
    var recipeIngredient9: String = ""
    var recipeIngredient10: String = ""
    var recipeIngredient11: String = ""
    var recipeIngredient12: String = ""
    var recipeIngredient13: String = ""
    var recipeIngredient14: String = ""
    var recipeIngredient15: String = ""
    var recipeIngredient16: String = ""
    var recipeIngredient17: String = ""
    var recipeIngredient18: String = ""
    var recipeIngredient19: String = ""
    var recipeIngredient20: String = ""
    var recipeMeasure1: String = ""
    var recipeMeasure2: String = ""
    var recipeMeasure3: String = ""
    var recipeMeasure4: String = ""
    var recipeMeasure5: String = ""
    var recipeMeasure6: String = ""
    var recipeMeasure7: String = ""
    var recipeMeasure8: String = ""
    var recipeMeasure9: String = ""
    var recipeMeasure10: String = ""
    var recipeMeasure11: String = ""
    var recipeMeasure12: String = ""
    var recipeMeasure13: String = ""
    var recipeMeasure14: String = ""
    var recipeMeasure15: String = ""
    var recipeMeasure16: String = ""
    var recipeMeasure17: String = ""
    var recipeMeasure18: String = ""
    var recipeMeasure19: String = ""
    var recipeMeasure20: String = ""
    var recipeInstructions: String = ""

    fun Modifier.bounceClickEffect() = composed {
        var isPressed by remember { mutableStateOf(false) }
        val scale by animateFloatAsState(if (isPressed) 0.70f else 1f)

        this
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .pointerInput(isPressed) {
                awaitPointerEventScope {
                    isPressed = if (isPressed) {
                        waitForUpOrCancellation()
                        false
                    } else {
                        awaitFirstDown(false)
                        true
                    }
                }
            }
    }

    if (rememberedDetails.value.isEmpty()) {

        Column() {
            Text("Trouble retrieving recipe.  Please refresh.")
            Button(onClick = { navController.navigate(MealsScreen.DetailsScreen.route + "/$details") }
            ,modifier = Modifier.bounceClickEffect().fillMaxWidth())
            {
                Text(text = "Refresh")
            }
        }

    } else {

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(MealsScreen.SavedRecipesScreen.route) }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.TwoTone.List,
                                contentDescription = "Top Bar Icon"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        titleContentColor = MaterialTheme.colorScheme.tertiary,
                    ),
                    title = {
                        Text("Recipe Details")
                    }
                )
            },
            floatingActionButton = {
                Row() {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(MealsScreen.CategoriesScreen.route)
                        },
                        modifier = Modifier.padding(all = 25.dp).bounceClickEffect(),
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.TwoTone.List,
                            contentDescription = null
                        )

                    }

                    FloatingActionButton(
                        onClick = {
                            savedRecipeViewModel.addRecipeItem(
                                SavedRecipe(
                                    recipeName = recipeName,
                                    recipeImage = recipeImage,
                                    recipeCategory = recipeCategory,
                                    recipeIngredient1 = recipeIngredient1,
                                    recipeIngredient2 = recipeIngredient2,
                                    recipeIngredient3 = recipeIngredient3,
                                    recipeIngredient4 = recipeIngredient4,
                                    recipeIngredient5 = recipeIngredient5,
                                    recipeIngredient6 = recipeIngredient6,
                                    recipeIngredient7 = recipeIngredient7,
                                    recipeIngredient8 = recipeIngredient8,
                                    recipeIngredient9 = recipeIngredient9,
                                    recipeIngredient10 = recipeIngredient10,
                                    recipeIngredient11 = recipeIngredient11,
                                    recipeIngredient12 = recipeIngredient12,
                                    recipeIngredient13 = recipeIngredient13,
                                    recipeIngredient14 = recipeIngredient14,
                                    recipeIngredient15 = recipeIngredient15,
                                    recipeIngredient16 = recipeIngredient16,
                                    recipeIngredient17 = recipeIngredient17,
                                    recipeIngredient18 = recipeIngredient18,
                                    recipeIngredient19 = recipeIngredient19,
                                    recipeIngredient20 = recipeIngredient20,
                                    recipeInstructions = recipeInstructions,
                                    recipeMeasure1 = recipeMeasure1,
                                    recipeMeasure2 = recipeMeasure2,
                                    recipeMeasure3 = recipeMeasure3,
                                    recipeMeasure4 = recipeMeasure4,
                                    recipeMeasure5 = recipeMeasure5,
                                    recipeMeasure6 = recipeMeasure6,
                                    recipeMeasure7 = recipeMeasure7,
                                    recipeMeasure8 = recipeMeasure8,
                                    recipeMeasure9 = recipeMeasure9,
                                    recipeMeasure10 = recipeMeasure10,
                                    recipeMeasure11 = recipeMeasure11,
                                    recipeMeasure12 = recipeMeasure12,
                                    recipeMeasure13 = recipeMeasure13,
                                    recipeMeasure14 = recipeMeasure14,
                                    recipeMeasure15 = recipeMeasure15,
                                    recipeMeasure16 = recipeMeasure16,
                                    recipeMeasure17 = recipeMeasure17,
                                    recipeMeasure18 = recipeMeasure18,
                                    recipeMeasure19 = recipeMeasure19,
                                    recipeMeasure20 = recipeMeasure20
                                )
                            )
                            Toast.makeText(context, "Recipe has been saved.", Toast.LENGTH_LONG)
                                .show()
                        },
                        modifier = Modifier.padding(all = 25.dp).bounceClickEffect(),
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = null)

                    }
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                items(rememberedDetails.value) { item ->
                    val coroutineScope = rememberCoroutineScope()

                    val dismissState = rememberSwipeToDismissBoxState(
                        confirmValueChange = { state ->
                            if (state == SwipeToDismissBoxValue.EndToStart || state == SwipeToDismissBoxValue.StartToEnd) {
                                coroutineScope.launch {
                                    delay(1.seconds)
                                    navController.navigate(MealsScreen.SavedRecipesScreen.route)
                                }
                                true
                            } else {
                                false
                            }
                        }
                    )

                    SwipeToDismissBox(
                        state = dismissState,
                        backgroundContent = {
                            val color by animateColorAsState(
                                when (dismissState.targetValue) {
                                    SwipeToDismissBoxValue.Settled -> Color.Black
                                    SwipeToDismissBoxValue.StartToEnd -> Color.White
                                    SwipeToDismissBoxValue.EndToStart -> Color.White

                                }, label = ""
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color)
                            )
                        },
                        content = {
                            Column() {
                                AsyncImage(
                                    model = item.strMealThumb,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .padding(4.dp),
                                )
                                recipeImage = item.strMealThumb
                                recipeName = item.strMeal
                                Text("Recipe Name: ${item.strMeal}")
                                recipeCategory = item.strCategory
                                Text("Recipe Category: ${item.strCategory}")
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Recipe YouTube Link: ${item.strYoutube}")
                                Spacer(modifier = Modifier.height(8.dp))
                                if (item.strIngredient1 != "")
                                    recipeIngredient1 = item.strIngredient1
                                recipeMeasure1 = item.strMeasure1
                                Text("Recipe Ingredient 1: ${item.strMeasure1} ${item.strIngredient1}")
                                if (item.strIngredient2 != "")
                                    recipeIngredient2 = item.strIngredient2
                                recipeMeasure2 = item.strMeasure2
                                Text("Recipe Ingredient 2: ${item.strMeasure2} ${item.strIngredient2}")
                                if (item.strIngredient3 != "")
                                    recipeIngredient3 = item.strIngredient3
                                recipeMeasure3 = item.strMeasure3
                                Text("Recipe Ingredient 3: ${item.strMeasure3} ${item.strIngredient3}")
                                if (item.strIngredient4 != "")
                                    recipeIngredient4 = item.strIngredient4
                                recipeMeasure4 = item.strMeasure4
                                Text("Recipe Ingredient 4: ${item.strMeasure4} ${item.strIngredient4}")
                                if (item.strIngredient5 != "")
                                    recipeIngredient5 = item.strIngredient5
                                recipeMeasure5 = item.strMeasure5
                                Text("Recipe Ingredient 5: ${item.strMeasure5} ${item.strIngredient5}")
                                if (item.strIngredient6 != "")
                                    recipeIngredient6 = item.strIngredient6
                                recipeMeasure6 = item.strMeasure6
                                Text("Recipe Ingredient 6: ${item.strMeasure6} ${item.strIngredient6}")
                                if (item.strIngredient7 != "")
                                    recipeIngredient7 = item.strIngredient7
                                recipeMeasure7 = item.strMeasure7
                                Text("Recipe Ingredient 7: ${item.strMeasure7} ${item.strIngredient7}")
                                if (item.strIngredient8 != "")
                                    recipeIngredient8 = item.strIngredient8
                                recipeMeasure8 = item.strMeasure8
                                Text("Recipe Ingredient 8: ${item.strMeasure8} ${item.strIngredient8}")
                                if (item.strIngredient9 != "")
                                    recipeIngredient9 = item.strIngredient9
                                recipeMeasure9 = item.strMeasure9
                                Text("Recipe Ingredient 9: ${item.strMeasure9} ${item.strIngredient9}")
                                if (item.strIngredient10 != "")
                                    recipeIngredient10 = item.strIngredient10
                                recipeMeasure10 = item.strMeasure10
                                Text("Recipe Ingredient 10: ${item.strMeasure10} ${item.strIngredient10}")
                                if (item.strIngredient11 != "")
                                    recipeIngredient11 = item.strIngredient11
                                recipeMeasure11 = item.strMeasure11
                                Text("Recipe Ingredient 11: ${item.strMeasure11} ${item.strIngredient11}")
                                if (item.strIngredient12 != "")
                                    recipeIngredient12 = item.strIngredient12
                                recipeMeasure12 = item.strMeasure12
                                Text("Recipe Ingredient 12: ${item.strMeasure12} ${item.strIngredient12}")
                                if (item.strIngredient13 != "")
                                    recipeIngredient6 = item.strIngredient13
                                recipeMeasure6 = item.strMeasure13
                                Text("Recipe Ingredient 13: ${item.strMeasure13} ${item.strIngredient13}")
                                if (item.strIngredient14 != "")
                                    recipeIngredient14 = item.strIngredient14
                                recipeMeasure14 = item.strMeasure14
                                Text("Recipe Ingredient 14: ${item.strMeasure14} ${item.strIngredient14}")
                                if (item.strIngredient15 != "")
                                    recipeIngredient15 = item.strIngredient15
                                recipeMeasure15 = item.strMeasure15
                                Text("Recipe Ingredient 15: ${item.strMeasure15} ${item.strIngredient15}")
                                if (item.strIngredient16 != "")
                                    recipeIngredient16 = item.strIngredient16
                                recipeMeasure16 = item.strMeasure16
                                Text("Recipe Ingredient 16: ${item.strMeasure16} ${item.strIngredient16}")
                                if (item.strIngredient17 != "")
                                    recipeIngredient17 = item.strIngredient17
                                recipeMeasure17 = item.strMeasure17
                                Text("Recipe Ingredient 17: ${item.strMeasure17} ${item.strIngredient17}")
                                if (item.strIngredient18 != "")
                                    recipeIngredient18 = item.strIngredient18
                                recipeMeasure18 = item.strMeasure18
                                Text("Recipe Ingredient 18: ${item.strMeasure18} ${item.strIngredient18}")
                                if (item.strIngredient19 != "")
                                    recipeIngredient19 = item.strIngredient19
                                recipeMeasure19 = item.strMeasure19
                                Text("Recipe Ingredient 19: ${item.strMeasure19} ${item.strIngredient19}")
                                if (item.strIngredient20 != "")
                                    recipeIngredient20 = item.strIngredient20
                                recipeMeasure20 = item.strMeasure20
                                Text("Recipe Ingredient 20: ${item.strMeasure20} ${item.strIngredient20}")
                                Spacer(modifier = Modifier.height(8.dp))
                                recipeInstructions = item.strInstructions
                                Text("Recipe Instructions: ${item.strInstructions}")
                            }

                        })
                }


            }
        }
    }
    }

package com.example.recipeasy


import FilterPage
import HomePage
import PantryPage
import PantryRecipePage
import RecipePage
import ShopPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipeasy.ui.theme.RecipeasyTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeasyTheme(dynamicColor = false) {
                var selectedPage by remember { mutableStateOf(Page.HOME) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (selectedPage) {
                        Page.HOME -> HomePage(
                            selectedPage = selectedPage,
                            onItemSelected = { page ->
                                selectedPage = page
                            }
                        )

                        Page.RECIPES -> PantryRecipePage(
                            selectedPage = selectedPage,
                            onItemSelected = { page ->
                                selectedPage = page
                            }
                        )

                        Page.PANTRY -> PantryPage(
                            selectedPage = selectedPage,
                            onItemSelected = { page ->
                                selectedPage = page
                            }
                        )

                        Page.PROFILE -> TODO()
                    }
                }

            }
        }
    }
}

enum class Page {
    HOME, RECIPES, PANTRY, PROFILE
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    var selectedPage by remember { mutableStateOf(Page.HOME) }
    RecipeasyTheme(dynamicColor = false) {
        HomePage(
            selectedPage = selectedPage,
            onItemSelected = { page ->
                selectedPage = page
            })
    }
}

@Preview(showBackground = true)
@Composable
fun PantryRecipePagePreview() {
    var selectedPage by remember { mutableStateOf(Page.HOME) }
    RecipeasyTheme(dynamicColor = false) {
        PantryRecipePage(
            selectedPage = selectedPage,
            onItemSelected = { page ->
                selectedPage = page
            })
    }
}

@Preview(showBackground = true)
@Composable
fun PantryPagePreview() {
    var selectedPage by remember { mutableStateOf(Page.HOME) }
    RecipeasyTheme(dynamicColor = false) {
        PantryPage(
            selectedPage = selectedPage,
            onItemSelected = { page ->
                selectedPage = page
            })
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPagePreview() {
    RecipeasyTheme(dynamicColor = false) {
        FilterPage()
    }
}

@Preview(showBackground = true)
@Composable
fun ShopPagePreview() {
    RecipeasyTheme(dynamicColor = false) {
        ShopPage()
    }
}

@Preview(showBackground = true)
@Composable
fun RecipePagePreview() {
    RecipeasyTheme(dynamicColor = false) {
        RecipePage()
    }
}




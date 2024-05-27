import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.recipeasy.R
import com.example.recipeasy.ui.AppViewModelProvider
import com.example.recipeasy.ui.NavigationDestination
import com.example.recipeasy.ui.pages.pantryrecipepage.PantryRecipeViewModel


object PantryRecipeDestination : NavigationDestination {
    override val route = "recipes"
}

@Composable
fun PantryRecipeScreen(
    modifier: Modifier = Modifier,
    selectedPage: Page,
    onItemSelected: (Page) -> Unit,
    navigateToFilter: () -> Unit,
    navigateToShop: () -> Unit,
    navigateToRecipeDetail: (String) -> Unit,
    navController: NavHostController,
) {
    Scaffold(
        topBar = {
            MainTopBar(
                selectedPage = selectedPage,
                onItemSelected = onItemSelected,
                onSearchClicked = navigateToFilter,
                modifier = modifier,
                onShopClicked = navigateToShop,
                navController = navController
            )
        }
    ) { innerPadding ->

        val viewModel: PantryRecipeViewModel = viewModel(factory = AppViewModelProvider.Factory)
        val pantryRecipeState by viewModel.recipesState.collectAsState()


        PantryRecipePageText(modifier = modifier.padding(innerPadding))
        RecipeCardList(
            modifier = modifier.padding(innerPadding),
            recipes = pantryRecipeState,
            onItemClick = navigateToRecipeDetail
        )
    }
}

@Composable
fun PantryRecipePageText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.recipes_with_ingredients),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}
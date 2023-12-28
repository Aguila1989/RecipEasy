import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.recipeasy.R

@Composable
fun RecipePage() {
    Column {
        SecondHeader("Chicken with vegetables")
        Recipe()
    }
}

@Composable
fun RecipeIcons() {
    val icons = listOf(
        Icons.Filled.AccountBox,
        Icons.Filled.Delete,
        Icons.Filled.ShoppingCart,
        Icons.Filled.ShoppingCart
    )

    val iconTitle = listOf(
        "Time",
        "Difficulty",
        "Servings",
        "Add to\nshop"
    )

    val iconText = listOf(
        "30 min",
        "Easy",
        "4",
        ""
    )
    Row(
        modifier = Modifier.width(320.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in 0..3) {
            Column {
                RecipeIcon(imageVector = icons[i], title = iconTitle[i], text = iconText[i])
            }
        }
    }
}

@Composable
fun RecipeIcon(imageVector: ImageVector, title: String, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "Shopping Cart",
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun RecipeText() {
    val ingredients = listOf(
        "- 1 tbsp olive oil",
        "- 1 onion, chopped",
        "- 2 garlic cloves, crushed",
        "- 1 tsp ground cumin",
        "- 1 tsp ground coriander",
        "- 1 tsp ground cinnamon",
        "- 1 tsp harissa paste",
        "- 400g can chopped tomatoes",
        "- 2 tbsp clear honey",
        "- 2 x 400g cans chickpeas, drained and rinsed",
        "- 1 lemon, juiced",
        "- 2 tbsp chopped coriander",
        "- 2 tbsp chopped parsley",
        "- 2 tbsp chopped mint",
        "- 100g feta cheese, crumbled",
    )

    val steps = listOf(
        "1. Heat the oil in a large saucepan and cook the onion for 5 mins until softened and starting to turn golden. Add the garlic and spices, and cook for 1 min more. Stir in the harissa, tomatoes and honey, and bubble together for 5 mins.",
        "2. Add the chickpeas to the pan with the lemon juice and seasoning, then simmer for 3 mins more. Stir through the herbs and scatter over the feta to serve."
    )

    Column(modifier = Modifier.width(320.dp)) {
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        ingredients.forEach {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        Divider()

        Text(
            text = "Preparation",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        steps.forEach {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Composable
fun Recipe() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RecipeArticleMirror(drawable = R.drawable.plate_1, text = R.string.empty_string)
        RecipeIcons()
        RecipeText()
    }
}
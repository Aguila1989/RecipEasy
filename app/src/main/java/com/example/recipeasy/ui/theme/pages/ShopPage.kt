import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipeasy.data.dataclasses.ShopArticle
import com.example.recipeasy.data.dataclasses.ShopItem

@Composable
fun ShopPage(shop: List<ShopArticle>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SecondHeader(title = "Shopping List")
        ShopIcons()
        ShopArticles(shop = shop)
    }
}

@Composable
fun ShopIcons() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.width(290.dp)
    ) {
        ShopIcon()
        ShopIcon()
        ShopIcon()
        ShopIcon()
    }
}

@Composable
fun ShopIcon() {
    Icon(
        imageVector = Icons.Filled.ShoppingCart,
        contentDescription = "Shopping Cart",
        modifier = Modifier.padding(6.dp)
    )
}



@Composable
fun ShopArticles(shop: List<ShopArticle>) {
    LazyColumn() {
        items(shop.size) { index ->
            val shopArticle = shop[index]
            ShopArticle(shopArticle = shopArticle)
        }
    }
}

@Composable
fun ShopItem(shopItem: ShopItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(320.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = true,
                onCheckedChange = { /*TODO*/ },
                modifier = Modifier.padding(6.dp)
            )
            Column {
                Text(
                    text = shopItem.quantity.toString() + " " + shopItem.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = shopItem.recipeTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        Icon(
            imageVector = Icons.Outlined.Edit,
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = "Shopping Cart",
            modifier = Modifier
                .padding(6.dp)
                .size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShopItemPreview() {
    ShopItem(shopItem = ShopItem(4, "Spare ribs", "Spare ribs with fried potatoes"))
}

@Composable
fun ShopArticle(modifier: Modifier = Modifier, shopArticle: ShopArticle) {
    Column {
        ShopTitle(title = shopArticle.title)
        Surface(
            shape = MaterialTheme.shapes.small,
            color = shopArticle.color,
            modifier = modifier
                .padding(vertical = 8.dp)
                .width(320.dp)
        ) {
            Column {
                shopArticle.shopItems.forEach { shopItem ->
                    ShopItem(shopItem = shopItem)
                }
            }
        }
    }
}

@Composable
fun ShopTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.secondary
    )
}
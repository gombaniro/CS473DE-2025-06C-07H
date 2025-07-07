package org.miu.grocery.shop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.*
import org.miu.grocery.shop.model.GroceryItem
import org.miu.grocery.shop.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { GroceryApp() }
    }
}

@Composable
fun GroceryApp() {
    val nav = rememberNavController()
    val cart = remember { mutableStateListOf<GroceryItem>() }

    Scaffold(bottomBar = { BottomBar(nav) }) { inner ->
        NavHost(nav, startDestination = "home", modifier = Modifier.padding(inner)) {
            composable("home") {
                HomeScreen(sampleItems()) { nav.navigate("detail/${it.name}") }
            }
            composable("detail/{name}") { back ->
                val item = sampleItems().first { it.name == back.arguments?.getString("name") }
                DetailScreen(item) { cart.add(item); nav.navigate("cart") }
            }
            composable("cart") { CartScreen(cart) }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun BottomBar(nav: NavHostController) {
    val items = listOf(
        Triple("home", "Home", Icons.Default.Home),
        Triple("cart", "Cart", Icons.Default.ShoppingCart),
        Triple("profile", "Profile", Icons.Default.Person)
    )
    NavigationBar {
        val current = nav.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                selected = current == route,
                onClick = { nav.navigate(route) { popUpTo("home") } },
                icon = { Icon(icon, label) },
                label = { Text(label) }
            )
        }
    }
}

fun sampleItems() = listOf(
    GroceryItem("Apple", R.drawable.apple, 0.89, "Fresh red apple."),
    GroceryItem("Cake", R.drawable.cake, 4.99, "Strawberry cake slice."),
    GroceryItem("Carrot", R.drawable.carrot, 0.49, "Organic carrot."),
    GroceryItem("Juice", R.drawable.juice, 2.49, "Orange juice.")
)
package org.miu.grocery.shop.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.miu.grocery.shop.model.GroceryItem

@Composable
fun CartScreen(cart: List<GroceryItem>) {
    val total = cart.sumOf { it.price }
    Column(Modifier.padding(16.dp)) {
        cart.forEach {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(it.name)
                Text("$${it.price}")
            }
        }
        Divider(Modifier.padding(vertical = 8.dp))
        Text("Total: $${"%.2f".format(total)}")
    }
}
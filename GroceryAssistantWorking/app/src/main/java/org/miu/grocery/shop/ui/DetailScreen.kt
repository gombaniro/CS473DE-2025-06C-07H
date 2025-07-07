package org.miu.grocery.shop.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.miu.grocery.shop.model.GroceryItem

@Composable
fun DetailScreen(item: GroceryItem, onAdd: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(painterResource(item.imageRes), contentDescription = item.name, modifier = Modifier.size(160.dp))
        Text(item.name)
        Text("$${item.price}")
        Text(item.description)
        Button(onClick = onAdd) { Text("Add to cart") }
    }
}
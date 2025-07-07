package org.miu.grocery.shop.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.miu.grocery.shop.model.GroceryItem

@Composable
fun HomeScreen(items: List<GroceryItem>, onClick: (GroceryItem) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            Card(modifier = Modifier.fillMaxWidth(), onClick = { onClick(item) }) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(item.imageRes), contentDescription = item.name, modifier = Modifier.size(64.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(item.name)
                        Text("$${item.price}")
                    }
                }
            }
        }
    }
}
package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.eighteentech.tala.entities.Item

@Composable
fun ItemList(content: List<Item>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(content){ item ->
            if (item.loan != null){
                Card(modifier = Modifier.fillMaxWidth().height(140.dp)) {
                    Text(text = item.username)
                }
            }else{
                Card(modifier = Modifier.fillMaxWidth().height(140.dp).background(Color.Cyan)) {
                    Text(text = item.username)
                }
            }

        }
    }
}
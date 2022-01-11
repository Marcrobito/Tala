package dev.eighteentech.tala.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Item() {
    Card(
        contentColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(text = "Hello", color = Color.Black )
    }
}


@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    Item()
}
package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.eighteentech.tala.R

@ExperimentalUnitApi
@Composable
fun TalaAppBar(title: String) {
    TopAppBar({
        Row {
            Image(
                painter = painterResource(R.drawable.tala_circle),
                contentDescription = "",
                modifier = Modifier
                    .height(28.dp)
                    .width(28.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = title,
                fontSize = TextUnit(24f, TextUnitType.Unspecified),
                fontWeight = FontWeight.Black
            )
        }
    })
}
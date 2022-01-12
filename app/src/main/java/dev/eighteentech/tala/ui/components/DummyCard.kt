package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.eighteentech.tala.R
import dev.eighteentech.tala.ui.theme.Orange
import java.util.*

@Composable
fun DummyCard(local: String) {
    val imageResource = when (local) {
        "mx" -> R.drawable.img_story_card_mx
        "ph" -> R.drawable.img_story_card_ph
        else -> R.drawable.img_story_card_ke
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)) {
        Box{
            Image(
                painter = painterResource(imageResource),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "“Tala helped me \n with my dream“",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,

            )
            TextButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White
                )
            ) {
                Text(text = "READ MORE")
            }
        }

    }


}
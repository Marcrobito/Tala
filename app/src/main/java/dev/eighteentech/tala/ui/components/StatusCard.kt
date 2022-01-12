package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.eighteentech.tala.entities.Level
import dev.eighteentech.tala.entities.Loan
import dev.eighteentech.tala.ui.theme.Orange


@Composable
fun StatusCard(loan: Loan?, locale: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                val secondText = if(loan == null) "Track your progress over time"
                else "Grow your limit up to ${(loan.due?:10000).toInt()} $locale"
                Text(
                    text = "My Tala status",
                    fontSize = 24.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = secondText,
                    color = Color.Gray,
                    fontSize = 16.sp,
                )
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Orange
                    )
                ) {
                    Text(text = "VIEW STATUS")
                }
            }
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {

                val imageResourceId = Level.level(loan?.level?:"").getResource()

                Image(
                    painter = painterResource(imageResourceId),
                    contentDescription = "",
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                )
            }
        }
    }
}
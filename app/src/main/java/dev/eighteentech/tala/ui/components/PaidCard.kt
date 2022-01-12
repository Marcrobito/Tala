package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.eighteentech.tala.R
import dev.eighteentech.tala.entities.Loan
import dev.eighteentech.tala.ui.theme.Orange
import dev.eighteentech.tala.ui.theme.TalaTeal

@Composable
fun PaidCard(loan: Loan, locale: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp).background(TalaTeal)
        ) {
            TileAndroidImage(
                drawableId = R.drawable.waves_bg_light_pattern,
                contentDescription = ""
            )
            Image(
                painter = painterResource(R.drawable.img_loan_status_paidoff),
                contentDescription = "",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
                Text(
                    text = "Your loan is fully paid",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Apply for another loan any time you want and grow your limit",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Orange, contentColor = Color.White),
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(text = "APPLY NOW")
                }
            }
        }
    }
}
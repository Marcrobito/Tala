package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.eighteentech.tala.entities.Loan
import dev.eighteentech.tala.ui.theme.TalaTeal
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DueCard(loan: Loan, locale: String) {

    val date = Date(loan.dueDate!!)
    val pattern = "EEEE dd MMM yyyy"
    val simpleDateFormat = SimpleDateFormat(pattern)
    val dueDate: String = simpleDateFormat.format(date)


    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(
                text = "You are on track!",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "$locale ${loan.due?.toInt()}",
                color = TalaTeal,
                fontSize = 32.sp,
            )
            Text(
                text = "Is due $dueDate",
                fontSize = 24.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "MAKE A PAYMENT")
                }
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color.Gray
                    )
                ) {
                    Text(text = "HOW TO REPAY")
                }
            }
        }
    }
}
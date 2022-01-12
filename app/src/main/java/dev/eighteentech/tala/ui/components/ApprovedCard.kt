package dev.eighteentech.tala.ui.components

import android.graphics.BitmapFactory
import android.graphics.Shader
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import dev.eighteentech.tala.R
import dev.eighteentech.tala.entities.Loan
import dev.eighteentech.tala.ui.theme.Orange
import dev.eighteentech.tala.ui.theme.TalaTeal


@Composable
fun ApprovedCard(loan: Loan, locale: String) {
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
                painter = painterResource(R.drawable.img_loan_status_approved),
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
                    text = "Your application approved",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "You've been approved for ${loan.approved?.toInt()} $locale",
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Orange, contentColor = Color.White)
                ) {
                    Text(text = "VIEW LOAN OFFER")
                }
            }
        }
    }
}

@Composable
fun TileAndroidImage(
    @DrawableRes drawableId: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val drawable = remember(drawableId) {
        BitmapDrawable(
            context.resources,
            BitmapFactory.decodeResource(
                context.resources,
                drawableId
            )
        ).apply {
            tileModeX = Shader.TileMode.REPEAT
            tileModeY = Shader.TileMode.REPEAT
        }
    }
    AndroidView(
        factory = {
            ImageView(it)
        },
        update = { imageView ->
            imageView.background = drawable
        },
        modifier = modifier
            .semantics {
                this.contentDescription = contentDescription
                role = Role.Image
            }
    )
}
package dev.eighteentech.tala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.eighteentech.tala.ui.theme.TalaTheme

@ExperimentalUnitApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TalaTheme {
                Column {
                    TalaAppBar("TALA")
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                        Card(
                            contentColor = Color.White,
                            elevation = 4.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                        ) {

                        }
                    }
                }
            }
            // A surface container using the 'background' color from the theme
            //Surface(color = MaterialTheme.colors.background) {
            //  Greeting("Android")
            //77}//
        }
    }
}

@ExperimentalUnitApi
@Composable
fun Greeting(name: String) {
    TalaAppBar(name)
}

@ExperimentalUnitApi
@Composable
fun TalaAppBar(name: String) {
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
                text = "$name",
                fontSize = TextUnit(24f, TextUnitType.Unspecified),
                fontWeight = FontWeight.Black
            )
        }
    })
}

@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TalaTheme {
        Column {
            TalaAppBar("TALA")
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Card(
                    contentColor = Color.White,
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                ) {

                }
            }

        }
    }
}
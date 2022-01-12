package dev.eighteentech.tala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.lifecycle.lifecycleScope
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dev.eighteentech.tala.entities.Response
import dev.eighteentech.tala.entities.Response.Uninitialized
import dev.eighteentech.tala.network.Api
import dev.eighteentech.tala.ui.components.MainView
import dev.eighteentech.tala.ui.theme.TalaTheme
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalUnitApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchItems()
        setContent {
            MainView(viewModel = viewModel)
        }
    }
}


@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TalaTheme {
        Column {
           

        }
    }
}
package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import dev.eighteentech.tala.MainViewModel
import dev.eighteentech.tala.entities.Response
import dev.eighteentech.tala.ui.theme.GrayBackground
import dev.eighteentech.tala.ui.theme.TalaTheme


@ExperimentalUnitApi
@Composable
fun MainView(viewModel: MainViewModel){
    val items = viewModel.items.collectAsState().value
    TalaTheme {
        Column(Modifier.background(GrayBackground)) {
            TalaAppBar("TALA")
            when(items){
                is Response.Uninitialized ->{

                }
                is Response.Success -> ItemList(content = items.data)
            }
        }
    }
}



@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //MainView()
}
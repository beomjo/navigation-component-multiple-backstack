package io.beomjo.multinav.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.beomjo.multinav.MyAppDestinations

@Composable
fun HomeScreen(){
    Text(MyAppDestinations.HOME_ROUTE)
}
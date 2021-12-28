package io.beomjo.multinav.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.beomjo.multinav.TabDirections

@Composable
fun HomeScreen(
    navigateToDetail: () -> Unit
) {
    Column {
        Text(TabDirections.HOME.route)
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { navigateToDetail() }) {
            Text("Move to Detail")
        }
    }
}
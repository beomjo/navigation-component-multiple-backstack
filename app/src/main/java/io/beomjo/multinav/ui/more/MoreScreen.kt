package io.beomjo.multinav.ui.more

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
fun MoreScreen(navigateToDetail: () -> Unit) {
    Column {
        Text(TabDirections.MORE.route)
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { navigateToDetail() }) {
            Text("Move to Detail")
        }
    }
}
package io.beomjo.multinav.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(from: String, content: @Composable () -> Unit = {}) {
    Column {
        Text(from)
        Spacer(modifier = Modifier.padding(10.dp))
        content()
    }
}
package io.beomjo.multinav.ui.company

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
fun CompanyScreen(navigateToDetail: () -> Unit) {
    Column {
        Text(TabDirections.COMPANY.route)
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { navigateToDetail() }) {
            Text("Move to Detail")
        }
    }
}
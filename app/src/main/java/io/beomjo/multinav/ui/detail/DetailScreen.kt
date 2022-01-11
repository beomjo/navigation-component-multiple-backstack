package io.beomjo.multinav.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.beomjo.multinav.ui.company.CompanyDirections

@Composable
fun DetailScreen(from: String, content: @Composable () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = from,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        content()
    }
}

@Composable
@Preview
fun DetailScreenPreview() {
    MaterialTheme {
        DetailScreen(from = CompanyDirections.DETAIL.route) {
            Button(onClick = {}) {
                Text("Move To Detail 2")
            }
        }
    }
}
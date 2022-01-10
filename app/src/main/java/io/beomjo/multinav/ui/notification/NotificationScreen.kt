package io.beomjo.multinav.ui.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.beomjo.multinav.TabDirections
import io.beomjo.multinav.ui.more.MoreScreen

@Composable
fun NotificationScreen(navigateToDetail: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "NotificationScreen",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { navigateToDetail() }) {
            Text("Move to DetailScreen")
        }
    }
}


@Composable
@Preview
fun NotificationScreenPreview() {
    MaterialTheme {
        NotificationScreen {

        }
    }
}
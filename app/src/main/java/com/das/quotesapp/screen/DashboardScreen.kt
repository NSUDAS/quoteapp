package com.das.quotesapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */
@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun DashboardScreen(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Define references for each composable
        val (title, button, lsit, imageRightside, subtitle) = createRefs()

        // Title Text
        Text(
            text = "Hello, ConstraintLayout!",
            fontSize = 24.sp,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "Hello, ConstraintLayout!",
            fontSize = 24.sp,
            modifier = Modifier
                .constrainAs(imageRightside) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.end)
                    end.linkTo(parent.start)
                }
        )

        // Subtitle Text
      Text(
            text = "Welcome to Compose ConstraintLayout",
            fontSize = 16.sp,
            modifier = Modifier
                .constrainAs(subtitle) {
                    top.linkTo(title.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )



        Row(
            modifier = Modifier
                .constrainAs(lsit) {
                    top.linkTo(title.bottom, margin = 18.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "DAS")
                Text(text = "SDHSJDHSD")
            }
            Text(text = "DAS")
            Text(text = "DAS")
            Text(text = "DAS")
        }

        // Button at Bottom Center
        androidx.compose.material3.Button(
            onClick = { /* TODO: Handle button click */ },
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom, margin = 32.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            BasicText(text = "Click Me")
        }
    }
}
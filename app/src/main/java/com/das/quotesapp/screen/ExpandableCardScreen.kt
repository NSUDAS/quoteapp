package com.das.quotesapp.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.core.R
import com.das.quotesapp.ui.theme.Shapes

/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */
@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun ExpandableCardScreen() {
    var expandableState by remember {
        mutableStateOf(false)
    }

    val rotationState by animateFloatAsState(targetValue = if (expandableState) 180f else 0f)

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                delayMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ), shape = Shapes.medium, onClick = {
        expandableState = !expandableState
    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "My Title",
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(modifier = Modifier
                    .weight(1f)
                    .rotate(rotationState), onClick = {
                    expandableState = !expandableState
                }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_call_answer),
                        contentDescription = null
                    )
                }
            }

            if (expandableState) {
                Text(
                    text = "jsdbsdjf bjskfsdjb fjsdbfjs bfjsbdfjsb fjbsdjfbs bfsjdfbjsdbfhjsdbfhsdbfhsdbfjhsdbfjhsbfsdfs" + "sdhsjdhsjd sjjdhsjdhhdjshdsjdhsjd",
                    fontStyle = MaterialTheme.typography.titleSmall.fontStyle,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


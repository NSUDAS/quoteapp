package com.das.quotesapp.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.das.quotesapp.R
import com.das.quotesapp.models.Puppy

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */

@Preview(showBackground = true)
@Composable
fun PuppyListItem() {
    Row(
        modifier = Modifier
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
}

@Preview(showBackground = true)
@Composable
fun cardData() {
    CardViewExample(
        "Das",
        "sdhsajdhajsdfbjasdb fjfasdbfjasdhbfhjasdf dhsgfhsdgfhsdfhsdfb hjdsfbjsdfbasdjfb dsfbs"
    )
}

@Composable
fun CardViewExample(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.labelLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, style = MaterialTheme.typography.bodyLarge)
        }
    }
}



@Composable
fun MyList(items: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items.size) { item ->
            ListItem(item = item.toString())
        }
    }
}


@Composable
fun ListItem(item: String) {
    Text(text = item, style = MaterialTheme.typography.titleSmall)
}

val androidNameList = listOf(

    AndroidVersion(R.drawable.ic_launcher_background, "Marshmallow", "October 5, 2015"),
    AndroidVersion(androidx.core.R.drawable.ic_call_answer, "Nougat", "August 22, 2016"),
    AndroidVersion(androidx.loader.R.drawable.notification_bg_normal, "Oreo", "August 21, 2017"),
    AndroidVersion(androidx.core.R.drawable.notification_action_background, "Pie", "August 6, 2018"),
    AndroidVersion(R.drawable.ic_launcher_background, "Android 10", "September 3, 2019"),
    AndroidVersion(androidx.core.R.drawable.ic_call_answer, "Android 11", "September 8, 2020")
)

data class AndroidVersion(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val release: String
)

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun ImageBelowText() {
    LazyRow {
        items(androidNameList) { item ->
                Column(
                    Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50)),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = item.imageResourceId),
                        contentDescription = null
                    )
                    Text(text = item.name)
                }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun ImageBelowText2() {
    LazyRow {
        items(androidNameList) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 100.dp, height = 140.dp), // Adjust size as needed
                shape = RoundedCornerShape(16.dp),


            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50)),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = item.imageResourceId),
                        contentDescription = null
                    )
                    Text(text = item.name)
                }
            }
        }
    }
}




@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun FullBackgroundColorView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA)) // Replace with your desired color
    ) {
        // Your content goes here, centered within the colored background
        Card() {


        LazyRow(
            modifier = Modifier.padding(16.dp)
        ) {
            items(androidNameList) { item ->
                Column(
                    Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50)),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = item.imageResourceId),
                        contentDescription = null
                    )
                    Text(text = item.name)
                }
            }
        }
        }
    }
}



@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun ImageBelowTextWithItemCLick() {
    LazyRow {
        items(androidNameList) { item ->
            Column(
                Modifier.padding(8.dp)
                    .clickable { println("Clicked on item: ${item.name}") },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = item.imageResourceId),
                    contentDescription = null
                )
                Text(text = item.name)
            }
        }
    }
}
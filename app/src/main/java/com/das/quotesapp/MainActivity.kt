package com.das.quotesapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SignalWifiStatusbarConnectedNoInternet4
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.das.quotesapp.include.QuotesState
import com.das.quotesapp.models.BreedModelItem
import com.das.quotesapp.navigation.MainNavigation
import com.das.quotesapp.ui.theme.QuotesAppTheme
import com.das.quotesapp.viewmodel.BreedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel : BreedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesAppTheme {
                MainNavigation()
                    }
//                    Scaffold(bottomBar = {
//                        // Create Bottom Navigation Bar
//                        BottomNavigationBar(navController = navController, currentDestination)
//                    }) { paddingVal ->
//
//
//                       //  Create NavHost to navigate between tabs
//                        NavHost(
//                            modifier = Modifier.padding(paddingVal),
//                            navController = navController,
//                            startDestination = BottomNavScreens.Home.route
//                        ) {
//                            // Define screens for each tab
//                            composable(BottomNavScreens.Home.route) {
//                                HomeScreen(navController = navController, viewModel)
//                            }
//
//                            composable(BottomNavScreens.Quote.route) {
//                                QuoteScreen(navController = navController, viewModel)
//                            }
//
//                            composable(BottomNavScreens.About.route) {
//                                AboutScreen(navController = navController)
//                            }
//
//
//
//                       }
//                    }
                }
            }
        }




@Composable
fun BreedScreen(viewModel: BreedViewModel) {
    val breedState = viewModel.response.collectAsState().value
    when (breedState) {
        is QuotesState.Loading -> {
            Text("Loading...")
        }
        is QuotesState.Success -> {
            breedState.data?.let { breed ->
                Text("Breed name: ${breed.name}") // Display breed info
            }
        }
        is QuotesState.Error -> {
            Text(breedState.message)
        }
    }
}


@Composable
fun CollegeList(colleges: List<BreedModelItem>) {
    LazyColumn {
        items(colleges) { college ->
            CollegeItem(college)
        }
    }
}

@Composable
fun CollegeItem(college: BreedModelItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = college.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Country: ${college.country}", style = MaterialTheme.typography.labelLarge)
        college.web_pages.forEach { webPage ->
            Text(text = "Website: $webPage", style = MaterialTheme.typography.labelLarge)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
    }
}

sealed class BottomNavScreens(val route: String) {
    object Home : BottomNavScreens("home")
    object Quote : BottomNavScreens("quotes")
    object About : BottomNavScreens("about")
}

@Composable
fun BottomNavigationBar(navController: NavHostController, currentDestination: NavDestination?) {
    val items = listOf(
        BottomNavScreens.Home, BottomNavScreens.Quote, BottomNavScreens.About
    )

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(icon = {
                when (screen) {
                    BottomNavScreens.Home -> Icon(
                        Icons.Default.Home, contentDescription = null, tint = Color.White
                    )

                    BottomNavScreens.Quote -> Icon(
                        Icons.Default.FormatQuote, contentDescription = null, tint = Color.White
                    )

                    BottomNavScreens.About -> Icon(
                        Icons.Default.Info, contentDescription = null, tint = Color.White
                    )
                }
            },
                label = { Text(screen.route.capitalize(), color = Color.White) },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                })
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, viewModel: BreedViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Quote of the Day", fontStyle = FontStyle.Italic, fontSize = 30.sp)
        RandomQuoteScreen(viewModel = viewModel)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 24.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp, 24.dp)
                    .clickable(onClick = {
                        viewModel.fetchBreedList()
                    }),
                tint = colorResource(id = R.color.white)
            )
        }
    }
}

@Composable
fun QuoteScreen(navController: NavHostController, viewModel: BreedViewModel) {
    val quoteState by viewModel.response.collectAsState()
    when (quoteState) {
        is QuotesState.Success -> {
            // Handle success state for regular quotes
            val quoteData = (quoteState as QuotesState.Success<BreedModelItem?>).data
            // Render UI with quoteData
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                //HorizontalPagerWithFadeTransition(quoteData!!.quotesResults)
            }

        }

        is QuotesState.Error -> {
            // Handle error state for regular quotes
            val errorMessage = (quoteState as QuotesState.Error).message
            // Render UI with errorMessage
            ShowError(errorMessage)
        }

        is QuotesState.Loading -> {
            // Handle loading state for regular quotes
            // Render loading indicator or any UI
            CenteredCircularProgressIndicator()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quote App") },
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )

                Text(
                    text = "Welcome to Quote App!",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = "by PixelDev",
                    style = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Italic),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Opening the Source code link",
                            Toast.LENGTH_SHORT
                        ).show()
                        uriHandler.openUri("https://github.com/Dinesh2510/")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("Source Code")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OptionItem(icon = Icons.Default.Home, text = "Home")
                    OptionItem(icon = Icons.Default.MailOutline, text = "Mail")
                    OptionItem(icon = Icons.Default.Info, text = "Info")
                    // Add more options as needed
                }
            }
        }
    )


}

@Composable
fun OptionItem(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Text(text = text)
        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
    }
}

@Composable
fun RandomQuoteScreen(viewModel: BreedViewModel) {
    val randomQuoteState by viewModel.response.collectAsState()
    val quotesResult = randomQuoteState
    QuoteCardRandom(quotesResult)
}

@Composable
fun QuoteCardRandom(randomQuoteState: QuotesState<BreedModelItem?>) {
    Log.e("TAG_randomQuoteState", "QuoteCardRandom: "+randomQuoteState )
    when (randomQuoteState) {
        is QuotesState.Success -> {
            // Handle success state for random quotes
            val randomQuoteData = (randomQuoteState as QuotesState.Success<BreedModelItem?>).data
            // Render UI with randomQuoteData
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(
                        //GradientStart: “#D9FF43”, GradientCenter: “#F67831”, GradientEnd: “#FF1493”
                        //generateRandomGradient()
                        brush = Brush.verticalGradient(
                            0.0f to Color.Magenta, 1.0f to Color.Cyan, startY = 0.0f, endY = 1500.0f
                        )
                    )
            ) {
                // Card content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
//                    randomQuoteData?.data?.get(1)?.attributes?.name?.let {
//                        Text(
//                            text = it,
//                            style = MaterialTheme.typography.titleMedium,
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 18.sp,
//                            modifier = Modifier.padding(bottom = 8.dp)
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
//
//                    Text(
//                        text = "- ${randomQuoteData?.data?.get(1)?.attributes?.name}",
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Normal,
//                        style = MaterialTheme.typography.labelSmall,
//                    )
                }

                // Quote icon button partially outside the card
                Icon(imageVector = Icons.Default.FormatQuote,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .align(Alignment.BottomCenter)
                        .background(Color.Transparent)
                        .clickable {
                            // Handle click action
                        })
            }

        }

        is QuotesState.Error -> {
            // Handle error state for random quotes
            val errorMessage = (randomQuoteState as QuotesState.Error).message
            // Render UI with errorMessage
            ShowError(errorMessage)
        }

        is QuotesState.Loading -> {
            // Handle loading state for random quotes
            // Render loading indicator or any UI
            CenteredCircularProgressIndicator()
        }
    }
}

@Composable
fun CenteredCircularProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp) // Set the size of the CircularProgressIndicator
                .align(Alignment.Center) // Align it to the center of the Box
        )
    }
}

@Composable
fun ShowError(message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Default.SignalWifiStatusbarConnectedNoInternet4,
                contentDescription = "contentDescription",
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(message)
        }

    }

}


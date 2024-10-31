package com.das.quotesapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.das.quotesapp.include.QuotesState
import com.das.quotesapp.viewmodel.QuotesRandmonViewModel

/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllQuotesListScreen(
    navController: NavController,
    viewModel: QuotesRandmonViewModel
) {
    val highSchoolState by viewModel.response.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "High School List")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack, "backIcon",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                )
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
        ) {
            when (highSchoolState) {
                is QuotesState.Loading -> {
                    Text("Loading...")
                }

                is QuotesState.Success -> {
                    val quotes = (highSchoolState as QuotesState.Success).data?.quotes ?: emptyList()
                    LazyColumn {
                        items (quotes) { quote ->
                         //   Text(text = quote.quote) // Adjust based on your data model
                            CellDesign(quote)
                        }
                    }
                }

                is QuotesState.Error -> {
                    Text((highSchoolState as QuotesState.Error).message)
                }
            }
        }
    }
}


package com.das.quotesapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.das.quotesapp.Routes.Routes
import com.das.quotesapp.screen.AllQuotesListScreen
import com.das.quotesapp.viewmodel.QuotesRandmonViewModel


/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val viewModel: QuotesRandmonViewModel = hiltViewModel()
    NavHost(navController, startDestination = Routes.MainRoute.SchoolList.route) {
        composable(route = Routes.MainRoute.SchoolList.route){
            AllQuotesListScreen(navController,viewModel)
        }
//        composable(route = Routes.MainRoute.SchoolDetails.route) {
//            HighSchoolDetailsScreen(navController,viewModel)
//        }
    }
}
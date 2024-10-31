package com.das.quotesapp.Routes

import androidx.navigation.NavController

/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */

sealed class Routes(val route: String) {

    data object MainRoute : Routes("mainRoutes") {

        data object SchoolList : Routes("${MainRoute.route}/schoolList") {
            fun NavController.toSchoolList() = navigate("${MainRoute.route}/schoolList")
        }

        data object SchoolDetails : Routes("${MainRoute.route}/schoolDetails") {
            fun NavController.toSchoolDetails() = navigate("${MainRoute.route}/schoolDetails")

        }
    }

}
package com.example.votingapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.votingapp.ui.screens.AddVoteScreen
import com.example.votingapp.ui.screens.VoteDetailsScreen
import com.example.votingapp.ui.screens.VoteListScreen
import com.example.votingapp.viewmodel.VoteViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: VoteViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.VOTE_LIST
    ) {
        composable(AppRoutes.VOTE_LIST) {
            VoteListScreen(
                viewModel = viewModel,
                onAddClick = { navController.navigate(AppRoutes.ADD_VOTE) },
                onItemClick = { optionId ->
                    navController.navigate(AppRoutes.voteDetails(optionId))
                }
            )
        }

        composable(AppRoutes.ADD_VOTE) {
            AddVoteScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = AppRoutes.VOTE_DETAILS,
            arguments = listOf(navArgument("optionId") { type = NavType.IntType })
        ) { backStackEntry ->
            val optionId = backStackEntry.arguments?.getInt("optionId") ?: return@composable
            VoteDetailsScreen(
                viewModel = viewModel,
                optionId = optionId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

package com.example.gregoryspoliceforce.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gregoryspoliceforce.ui.screens.ForceDetailScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gregoryspoliceforce.ui.screens.ForceListScreen
import com.example.gregoryspoliceforce.R
import kotlinx.coroutines.launch

enum class PoliceScreen(@StringRes val title: Int) {
    Home(title = R.string.force_list_screen),
    Detail(title = R.string.force_detail_screen)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun PoliceAppBar(
    modifier: Modifier = Modifier,
    currentScreen: PoliceScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun PoliceApp(viewModel: PoliceViewModel, modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    val coroutineScope = rememberCoroutineScope()

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = PoliceScreen.valueOf(
        backStackEntry?.destination?.route ?: PoliceScreen.Home.name
    )
    Scaffold(
        topBar = {
            PoliceAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = PoliceScreen.Home.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = PoliceScreen.Home.name) {
                ForceListScreen(
                    onPoliceListClick = {
                        coroutineScope.launch {
                            viewModel.intentChannel.send(PoliceIntent.OnPoliceListClick(it))
                            navController.navigate(PoliceScreen.Detail.name)
                        }
                    }, forceListUiState = viewModel.forceListUiState
                )
            }
            composable(route = PoliceScreen.Detail.name) {
                ForceDetailScreen(
                    forceDetailUiState = viewModel.forceDetailUiState
                )
            }
        }
    }
}
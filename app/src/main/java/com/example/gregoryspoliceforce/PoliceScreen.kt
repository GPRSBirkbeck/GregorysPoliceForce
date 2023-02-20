package com.example.gregoryspoliceforce

import android.content.ContentValues.TAG
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.screens.ForceDetailScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gregoryspoliceforce.ui.screens.ForceListScreen

enum class PoliceScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Detail(title = R.string.force_detail_screen)
    //TODO add officers?
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@Composable
fun PoliceAppBar(
    currentScreen: PoliceScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    modifier: Modifier = Modifier
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
                        viewModel.setPoliceForce(it)
                        Log.d(TAG, "PoliceApp: Police Force set to $it")
                        navController.navigate(PoliceScreen.Detail.name)
                    }, forceListUiState = viewModel.forceListUiState
                )
            }
            composable(route = PoliceScreen.Detail.name) {
                val context = LocalContext.current
                ForceDetailScreen(
                    forceDetailUiState = viewModel.forceDetailUiState
                )
            }
        }
    }
}
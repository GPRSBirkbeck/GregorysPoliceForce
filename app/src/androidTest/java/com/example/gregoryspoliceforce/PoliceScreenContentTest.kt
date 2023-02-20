package com.example.gregoryspoliceforce

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.components.ERROR_TAG
import com.example.gregoryspoliceforce.ui.screens.FORCE_LIST_TEST_TAG
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PoliceScreenContentTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Test
    fun policeScreen_ForceList_is_populated() {
        composeTestRule.setContent {
            val policeViewModel = PoliceViewModel(
                policeRepository = FakeNetworkPoliceRepository()
            )

            navController =
                TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(
                ComposeNavigator()
            )
            PoliceApp(navController = navController, viewModel = policeViewModel)
        }

        composeTestRule.onNodeWithTag(FORCE_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(4)
    }

    @Test
    fun policeScreen_ErrorMessage_is_displayed() {
        composeTestRule.setContent {
            val policeViewModel = PoliceViewModel(
                policeRepository = FakeFailedNetworkPoliceRepository()
            )

            navController =
                TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(
                ComposeNavigator()
            )
            PoliceApp(navController = navController, viewModel = policeViewModel)
        }
        composeTestRule.onNodeWithTag(ERROR_TAG)
            .assertExists()
    }

}
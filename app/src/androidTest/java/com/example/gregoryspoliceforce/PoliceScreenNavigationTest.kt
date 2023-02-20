package com.example.gregoryspoliceforce

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.screens.FORCE_DETAIL_NAME_TAG
import com.example.gregoryspoliceforce.ui.screens.FORCE_LIST_TEST_TAG
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PoliceScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupPoliceNavHost() {
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
    }

    @Test
    fun policeNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(PoliceScreen.Home.name)
    }

    @Test
    fun policeNavHost_verifyBackNavigationNotShownOnForceListScreen() {
        val backText = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    @Test
    fun policeNavHost_clickOnFirst_navigatesToForceDetailScreen() {
        composeTestRule.onNodeWithTag(FORCE_LIST_TEST_TAG)
            .onChildren()
            .onFirst()
            .performClick()
        navController.assertCurrentRouteName(PoliceScreen.Detail.name)
    }

    @Test
    fun policeNavHost_clickOnFirst_navigatesToForceDetailScreenAndScreenIsPopulated() {
        composeTestRule.onNodeWithTag(FORCE_LIST_TEST_TAG)
            .onChildren()
            .onFirst()
            .performClick()
        composeTestRule.onNodeWithTag(FORCE_DETAIL_NAME_TAG)
            .assertExists()
    }
}
package com.example.gregoryspoliceforce.fake

import com.example.gregoryspoliceforce.ui.state.ForceDetailUiState
import com.example.gregoryspoliceforce.ui.state.ForceListUiState
import com.example.gregoryspoliceforce.rules.TestDispatcherRule
import com.example.gregoryspoliceforce.ui.PoliceIntent
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class PoliceViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun policeViewModel_getForceList_verifyForceListUiStateSuccess() =
        runTest{

            val policeViewModel = PoliceViewModel(
                policeRepository = FakeNetworkPoliceRepository()
            )

            assertEquals(
                ForceListUiState.Success(FakeDataSource.fakeForceList),
                policeViewModel.forceListUiState
            )
        }

    //TODO needs to call the method to nav to detail screen
    @Test
    fun policeViewModel_getForceDetail_verifyForceDetailUiStateSuccess() =
        runTest{
            val policeViewModel = PoliceViewModel(
                policeRepository = FakeNetworkPoliceRepository()
            )
            policeViewModel.intentChannel.send(PoliceIntent.OnPoliceListClick("leicester"))
            assertEquals(
                ForceDetailUiState.Success(FakeDataSource.fakeForceDetail),
                policeViewModel.forceDetailUiState
            )
        }

}
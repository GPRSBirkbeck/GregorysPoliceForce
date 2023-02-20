package com.example.gregoryspoliceforce.fake

import com.example.gregoryspoliceforce.state.DefaultPoliceRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkPoliceRepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun networkPoliceRepository_getForceList_verifyForceList() = runTest {
        val repository = DefaultPoliceRepository(
            policeApi = FakePoliceApiService()
        )
        assertEquals(FakeDataSource.fakeForceList, repository.getForceList())

    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun networkPoliceRepository_getSpecificForce_verifySpecificForce() = runTest {
        val repository = DefaultPoliceRepository(
            policeApi = FakePoliceApiService()
        )
        assertEquals(
            FakeDataSource.fakeForceDetail, repository.getSpecificForce("leicestershire")
        )
    }

}
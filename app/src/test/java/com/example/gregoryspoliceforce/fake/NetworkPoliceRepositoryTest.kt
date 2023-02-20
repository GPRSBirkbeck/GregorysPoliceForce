package com.example.gregoryspoliceforce.fake

import com.example.gregoryspoliceforce.state.DefaultPoliceRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkPoliceRepositoryTest {

    @Test
    fun networkPoliceRepository_getForceList_verifyForceList() =
        runTest {
            val repository = DefaultPoliceRepository(
                policeApi = FakePoliceApiService()
            )
            assertEquals(FakeDataSource.fakeForceList, repository.getForceList())

        }


    @Test
    fun networkPoliceRepository_getSpecificForce_verifySpecificForce() =
        runTest {
            val repository = DefaultPoliceRepository(
                policeApi = FakePoliceApiService()
            )
            assertEquals(
                FakeDataSource.fakeForceDetail,
                repository.getSpecificForce("leicestershire")
            )
        }

}
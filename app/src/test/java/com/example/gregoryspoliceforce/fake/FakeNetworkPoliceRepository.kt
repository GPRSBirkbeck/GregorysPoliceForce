package com.example.gregoryspoliceforce.fake

import com.example.gregoryspoliceforce.state.PoliceRepository
import com.example.gregoryspoliceforce.data.model.Force
import com.example.gregoryspoliceforce.data.model.ForceDetail

class FakeNetworkPoliceRepository : PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return FakeDataSource.fakeForceList
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return FakeDataSource.fakeForceDetail
    }
}
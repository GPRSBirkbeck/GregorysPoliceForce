package com.example.gregoryspoliceforce

import com.example.gregoryspoliceforce.data.model.Force
import com.example.gregoryspoliceforce.data.model.ForceDetail
import com.example.gregoryspoliceforce.state.PoliceRepository

class FakeNetworkPoliceRepository : PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return FakeDataSource.fakeForceList
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return FakeDataSource.fakeForceDetail
    }
}

class FakeFailedNetworkPoliceRepository : PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return FakeDataSource.emptyList
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        TODO("Not yet implemented")
    }
}
package com.example.gregoryspoliceforce

import com.example.gregoryspoliceforce.data.PoliceRepository
import com.example.gregoryspoliceforce.datamodel.Force
import com.example.gregoryspoliceforce.datamodel.ForceDetail

class FakeNetworkPoliceRepository: PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return FakeDataSource.fakeForceList
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return FakeDataSource.fakeForceDetail
    }
}

class FakeFailedNetworkPoliceRepository: PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return FakeDataSource.emptyList
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        TODO("Not yet implemented")
    }
}
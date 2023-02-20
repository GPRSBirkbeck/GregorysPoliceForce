package com.example.gregoryspoliceforce.fake

import com.example.gregoryspoliceforce.datamodel.Force
import com.example.gregoryspoliceforce.datamodel.ForceDetail
import com.example.gregoryspoliceforce.network.PoliceApi

class FakePoliceApiService: PoliceApi() {
    override suspend fun getForceList(): List<Force> {
        return FakeDataSource.fakeForceList
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return FakeDataSource.fakeForceDetail
    }
}

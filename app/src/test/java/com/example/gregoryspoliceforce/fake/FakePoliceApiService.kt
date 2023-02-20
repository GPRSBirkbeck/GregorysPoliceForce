package com.example.gregoryspoliceforce.fake

import com.example.gregoryspoliceforce.data.model.Force
import com.example.gregoryspoliceforce.data.model.ForceDetail
import com.example.gregoryspoliceforce.data.network.PoliceApi

class FakePoliceApiService : PoliceApi() {
    override suspend fun getForceList(): List<Force> {
        return FakeDataSource.fakeForceList
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return FakeDataSource.fakeForceDetail
    }
}

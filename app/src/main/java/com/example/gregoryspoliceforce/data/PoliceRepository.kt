package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail
import com.example.gregoryspoliceforce.network.PoliceApi

interface PoliceRepository {
    suspend fun getForceList(): List<Force>
    suspend fun getSpecificForce(): ForceDetail
}

class DefaultPoliceRepository: PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return PoliceApi.retrofitService.getForceList()
    }

    override suspend fun getSpecificForce(): ForceDetail {
        return PoliceApi.retrofitService.getSpecificForce()
    }

}
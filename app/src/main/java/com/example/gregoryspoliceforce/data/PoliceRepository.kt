package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail
import com.example.gregoryspoliceforce.network.PoliceApiService

interface PoliceRepository {
    suspend fun getForceList(): List<Force>
    suspend fun getSpecificForce(): ForceDetail
}

class DefaultPoliceRepository(private val policeApiService: PoliceApiService
) : PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return policeApiService.getForceList()
    }

    override suspend fun getSpecificForce(): ForceDetail {
        return policeApiService.getSpecificForce()
    }

}
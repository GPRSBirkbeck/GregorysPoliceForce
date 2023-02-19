package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail
import com.example.gregoryspoliceforce.network.PoliceApi
import com.example.gregoryspoliceforce.network.PoliceApiService
import javax.inject.Inject
import javax.inject.Singleton

interface PoliceRepository {
    suspend fun getForceList(): List<Force>
    suspend fun getSpecificForce(id: String): ForceDetail
}

class DefaultPoliceRepository @Inject constructor(private val policeApi: PoliceApi
) : PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return policeApi.retrofitService.getForceList()
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return policeApi.retrofitService.getSpecificForce(id = id)
    }
}
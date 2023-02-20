package com.example.gregoryspoliceforce.state

import com.example.gregoryspoliceforce.data.model.Force
import com.example.gregoryspoliceforce.data.model.ForceDetail
import com.example.gregoryspoliceforce.data.network.PoliceApi
import javax.inject.Inject


interface PoliceRepository {
    suspend fun getForceList(): List<Force>
    suspend fun getSpecificForce(id: String): ForceDetail
}

class DefaultPoliceRepository @Inject constructor(
    private val policeApi: PoliceApi
) : PoliceRepository {
    override suspend fun getForceList(): List<Force> {
        return policeApi.getForceList()
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return policeApi.getSpecificForce(id = id)
    }
}
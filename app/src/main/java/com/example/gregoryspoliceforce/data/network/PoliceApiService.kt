package com.example.gregoryspoliceforce.data.network

import com.example.gregoryspoliceforce.data.model.Force
import com.example.gregoryspoliceforce.data.model.ForceDetail
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.http.Path
import javax.inject.Inject

private const val BASE_URL = "https://data.police.uk/api/"

@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL).build()

open class PoliceApi @Inject constructor() : PoliceApiService {
    private val retrofitService: PoliceApiService by lazy {
        retrofit.create(PoliceApiService::class.java)
    }

    override suspend fun getForceList(): List<Force> {
        return retrofitService.getForceList()
    }

    override suspend fun getSpecificForce(id: String): ForceDetail {
        return retrofitService.getSpecificForce(id = id)
    }


}

interface PoliceApiService {
    @GET("forces")
    suspend fun getForceList(): List<Force>

    @GET("forces/{id}")
    suspend fun getSpecificForce(@Path("id") id: String): ForceDetail


}
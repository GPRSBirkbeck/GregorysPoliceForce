package com.example.gregoryspoliceforce.network
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.http.Path
import retrofit2.http.Query


interface PoliceApiService {
    @GET("forces")
    suspend fun getForceList(): List<Force>

    @GET("forces/{id}")
    suspend fun getSpecificForce(@Path("id") id: String): ForceDetail
}
package com.example.gregoryspoliceforce.network
import com.example.gregoryspoliceforce.data.PoliceRepository
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

private const val BASE_URL =
    "https://data.police.uk/api/"

@OptIn(ExperimentalSerializationApi::class)
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

class PoliceApi @Inject constructor() {
    val retrofitService: PoliceApiService by lazy {
        retrofit.create(PoliceApiService::class.java)
    }
}

interface PoliceApiService {
    @GET("forces")
    suspend fun getForceList(): List<Force>

    @GET("forces/{id}")
    suspend fun getSpecificForce(@Path("id") id: String): ForceDetail


}
package com.example.gregoryspoliceforce.network
import com.example.gregoryspoliceforce.model.Force
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType

private const val BASE_URL =
    "https://data.police.uk/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .baseUrl(BASE_URL)
    .build()

interface PoliceApiService {
    @GET("forces")
    suspend fun getForceList(): List<Force>
}

object PoliceApi { //TODO replace with DI instead of singleton
    val retrofitService : PoliceApiService by lazy {
        retrofit.create(PoliceApiService::class.java)

    }

}
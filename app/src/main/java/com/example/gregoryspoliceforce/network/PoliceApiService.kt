package com.example.gregoryspoliceforce.network
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://data.police.uk" //TODO update this

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PoliceApiService {
    @GET("forces")
    suspend fun getForceList(): String
}

object PoliceApi {
    val retrofitService : PoliceApiService by lazy {
        retrofit.create(PoliceApiService::class.java)

    }

}
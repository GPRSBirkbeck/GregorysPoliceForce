package com.example.gregoryspoliceforce.network
import com.example.gregoryspoliceforce.model.Force
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://data.police.uk/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PoliceApiService {
    @GET("forces")
    suspend fun getForceList(): List<Force>
    @GET("forces")
    suspend fun getForceListAsString(): String //TODO delete

}

object PoliceApi { //TODO replace with DI instead of singleton
    val retrofitService : PoliceApiService by lazy {
        retrofit.create(PoliceApiService::class.java)

    }

}
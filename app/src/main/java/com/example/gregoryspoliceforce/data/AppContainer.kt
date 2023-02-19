package com.example.gregoryspoliceforce.data

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gregoryspoliceforce.network.PoliceApiService
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

interface AppContainer {
    val policeRepository: PoliceRepository
//    val policeViewModel: PoliceViewModel
}

class DefaultAppContainer : AppContainer {

    private val BASE_URL =
        "https://data.police.uk/api/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : PoliceApiService by lazy {
        retrofit.create(PoliceApiService::class.java)

    }
    override val policeRepository: PoliceRepository by lazy {
        DefaultPoliceRepository(retrofitService)
    }
//
//    override val policeViewModel: PoliceViewModel =
//            viewModel(factory = PoliceViewModel.Factory)
}
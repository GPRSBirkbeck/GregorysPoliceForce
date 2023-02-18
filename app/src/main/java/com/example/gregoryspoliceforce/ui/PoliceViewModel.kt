package com.example.gregoryspoliceforce.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gregoryspoliceforce.data.MockDataSource
import com.example.gregoryspoliceforce.data.PoliceOnlineUiState
import com.example.gregoryspoliceforce.data.PoliceUiState
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.network.PoliceApi
import com.example.gregoryspoliceforce.network.PoliceApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class PoliceViewModel : ViewModel() {



    private val _uiState = MutableStateFlow(PoliceUiState())

    val uiState: StateFlow<PoliceUiState> = _uiState.asStateFlow()
    var policeOnlineUiState: PoliceOnlineUiState by mutableStateOf(PoliceOnlineUiState.Loading)
        private set
    private lateinit var selectedPoliceForce: String

    private lateinit var forceList: List<Force>

    private fun getForceList(): List<Force> {
        forceList = MockDataSource().LoadMockPoliceSource()
        return MockDataSource().LoadMockPoliceSource()
    }

    private fun getOnlineForceList(): List<Force> {
        var listResult: List<Force> = ArrayList<Force>()
        viewModelScope.launch {
            try {
                //TODO uncomment
//            val listResult = PoliceApi.retrofitService.getForceList()
//            _uiState.value = PoliceUiState(onlineForceList = listResult)
//            Log.d(TAG, "getOnlineForceList: $listResult")
                listResult = PoliceApi.retrofitService.getForceList()
                policeOnlineUiState = PoliceOnlineUiState.Success(onlineForceListAsString = listResult)
                Log.d(TAG, "getOnlineForceList: $listResult")

            } catch (e: IOException) {
                policeOnlineUiState = PoliceOnlineUiState.Error

            }
        }
        return listResult
    }

    fun setPoliceForce(force: String){
        selectedPoliceForce = force
    }
    init {
        _uiState.value = PoliceUiState(forceList = getForceList())
        //TODO setup a reset block see part 5: https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-viewmodel-and-state#4
        // resetScreen
        getOnlineForceList()
    }

}

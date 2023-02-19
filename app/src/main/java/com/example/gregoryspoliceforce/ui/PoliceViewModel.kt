package com.example.gregoryspoliceforce.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.gregoryspoliceforce.GregorysPoliceForceApplication
import com.example.gregoryspoliceforce.data.*
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class PoliceViewModel(private val policeRepository: PoliceRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(PoliceUiState())

    val uiState: StateFlow<PoliceUiState> = _uiState.asStateFlow()
    var policeOnlineUiState: PoliceOnlineUiState by mutableStateOf(PoliceOnlineUiState.Loading)
        private set
    var detailPoliceOnlineUiState: DetailPoliceOnlineUiState by mutableStateOf(DetailPoliceOnlineUiState.Loading)
        private set
    private lateinit var selectedPoliceForce: String

    private fun getOnlineForceList(): List<Force> {
        var listResult: List<Force> = ArrayList<Force>()
        viewModelScope.launch {
            try {
                listResult = policeRepository.getForceList()
                policeOnlineUiState = PoliceOnlineUiState.Success(onlineForceList = listResult)
                Log.d(TAG, "getOnlineForceList: $listResult")

            } catch (e: IOException) {
                policeOnlineUiState = PoliceOnlineUiState.Error

            }
        }
        return listResult
    }

    private fun getSpecificOnlineForce() {
        viewModelScope.launch {
            try {
                val forceDetail = policeRepository.getSpecificForce()
                detailPoliceOnlineUiState = DetailPoliceOnlineUiState.Success(onlineForceDetail = forceDetail)
                Log.d(TAG, "getOnlineForceDetail: $detailPoliceOnlineUiState")

            } catch (e: IOException) {
                policeOnlineUiState = PoliceOnlineUiState.Error

            }
        }
    }

    fun setPoliceForce(force: String){
        selectedPoliceForce = force
        getSpecificOnlineForce()
    }
    init {
        //_uiState.value = PoliceUiState(forceList = getForceList())
        //TODO setup a reset block see part 5: https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-viewmodel-and-state#4
        // resetScreen
        getOnlineForceList()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as GregorysPoliceForceApplication)
                val policeRepository = application.container.policeRepository
                PoliceViewModel(policeRepository = policeRepository)
            }
        }
    }
}

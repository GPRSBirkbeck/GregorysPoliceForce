package com.example.gregoryspoliceforce.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gregoryspoliceforce.data.*
import com.example.gregoryspoliceforce.datamodel.Force
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PoliceViewModel @Inject constructor(private val policeRepository: PoliceRepository) :
    ViewModel() {

    var forceListUiState: ForceListUiState by mutableStateOf(ForceListUiState.Loading)
        private set
    var forceDetailUiState: ForceDetailUiState by mutableStateOf(ForceDetailUiState.Loading)
        private set
    private lateinit var selectedPoliceForce: String

    private fun getForceList(): List<Force> {
        var listResult: List<Force> = ArrayList<Force>()
        viewModelScope.launch {
            try {
                listResult = policeRepository.getForceList()
                if (listResult.size == 0){
                    forceListUiState = ForceListUiState.Error
                }
                else{
                    forceListUiState = ForceListUiState.Success(forceList = listResult)
                }
            } catch (e: IOException) {
                forceListUiState = ForceListUiState.Error

            }
        }
        return listResult
    }

    private fun getSpecificForce() {
        viewModelScope.launch {
            try {
                val forceDetail = policeRepository.getSpecificForce(selectedPoliceForce)
                forceDetailUiState = ForceDetailUiState.Success(forceDetail = forceDetail)
                Log.d(TAG, "getForceDetail: $forceDetailUiState")

            } catch (e: IOException) {
                forceListUiState = ForceListUiState.Error

            }
        }
    }

    fun setPoliceForce(force: String) {
        selectedPoliceForce = force
        getSpecificForce()
    }
    init {
        getForceList()
    }
}

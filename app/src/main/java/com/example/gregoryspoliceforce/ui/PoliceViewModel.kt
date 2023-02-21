package com.example.gregoryspoliceforce.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gregoryspoliceforce.state.*
import com.example.gregoryspoliceforce.data.model.Force
import com.example.gregoryspoliceforce.ui.state.ForceDetailUiState
import com.example.gregoryspoliceforce.ui.state.ForceListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
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

    private fun getForceList(): List<Force> {
        var listResult: List<Force> = ArrayList()
        viewModelScope.launch {
            try {
                listResult = policeRepository.getForceList()
                forceListUiState = if (listResult.isEmpty()) {
                    ForceListUiState.Error
                } else {
                    ForceListUiState.Success(forceList = listResult)
                }
            } catch (e: IOException) {
                forceListUiState = ForceListUiState.Error

            }
        }
        return listResult
    }


    val intentChannel = Channel<PoliceIntent>(Channel.UNLIMITED)
    private fun processIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect {
                when (it) {
                    is PoliceIntent.OnPoliceListClick -> getSpecificForceIntent(it.force)
                    else -> {//TODO add more if I get other actions }
                    }
                }
            }

        }
    }

    private fun getSpecificForceIntent(force: String) {
        viewModelScope.launch {
            try {
                val forceDetail = policeRepository.getSpecificForce(force)
                if (forceDetail.name.isNullOrBlank()) {
                    forceDetailUiState = ForceDetailUiState.Error
                } else {
                    forceDetailUiState = ForceDetailUiState.Success(forceDetail = forceDetail)
                    Log.d(TAG, "getForceDetail: $forceDetailUiState")
                }
            } catch (e: IOException) {
                forceDetailUiState = ForceDetailUiState.Error

            }
        }
    }

    init {
        processIntent()
        getForceList()
    }
}

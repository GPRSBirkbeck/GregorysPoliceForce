package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail

data class PoliceUiState(
    val selectedPoliceForce: String = "",
    val forceList: List<Force> = ArrayList<Force>()
)

sealed interface ForceListUiState {
    data class Success(val forceList: List<Force>) : ForceListUiState
    object Error : ForceListUiState
    object Loading : ForceListUiState
}

sealed interface ForceDetailUiState {
    data class Success(val forceDetail: ForceDetail) : ForceDetailUiState
    object Error : ForceDetailUiState
    object Loading : ForceDetailUiState
}

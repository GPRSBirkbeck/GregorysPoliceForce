package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.datamodel.Force
import com.example.gregoryspoliceforce.datamodel.ForceDetail


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

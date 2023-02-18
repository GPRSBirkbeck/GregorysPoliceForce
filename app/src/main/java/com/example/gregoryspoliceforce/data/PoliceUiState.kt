package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force

data class PoliceUiState(
    val selectedPoliceForce: String = "", //TODO see if we need this
    val forceList: List<Force> = ArrayList<Force>(),
    val onlineForceList: List<Force> = ArrayList<Force>(),
    //val onlineForceListAsString: String = ""
)

//TODO merge these once you've read up on sealed interfaces
sealed interface PoliceOnlineUiState {
    data class Success(val onlineForceListAsString: List<Force>) : PoliceOnlineUiState
    object Error : PoliceOnlineUiState
    object Loading : PoliceOnlineUiState
}

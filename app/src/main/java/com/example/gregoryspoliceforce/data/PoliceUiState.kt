package com.example.gregoryspoliceforce.data

import com.example.gregoryspoliceforce.model.Force

data class PoliceUiState(
    val selectedPoliceForce: String = "", //TODO see if we need this
    val forceList: List<Force> = ArrayList<Force>()

)

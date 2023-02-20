package com.example.gregoryspoliceforce.ui

sealed class PoliceIntent {
    data class OnPoliceListClick(val force: String): PoliceIntent()
}



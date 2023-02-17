package com.example.gregoryspoliceforce.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class PoliceViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PoliceUiState())
}

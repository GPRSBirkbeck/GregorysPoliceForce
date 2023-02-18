package com.example.gregoryspoliceforce.ui

import androidx.lifecycle.ViewModel
import com.example.gregoryspoliceforce.data.MockDataSource
import com.example.gregoryspoliceforce.data.PoliceUiState
import com.example.gregoryspoliceforce.model.Force
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PoliceViewModel : ViewModel() {



    private val _uiState = MutableStateFlow(PoliceUiState())

    val uiState: StateFlow<PoliceUiState> = _uiState.asStateFlow()

    private lateinit var selectedPoliceForce: String

    private lateinit var forceList: List<Force>

    private fun getForceList(): List<Force> {
        forceList = MockDataSource().LoadMockPoliceSource()
        return MockDataSource().LoadMockPoliceSource()
    }

    fun setPoliceForce(force: String){
        selectedPoliceForce = force
    }
    init {
        _uiState.value = PoliceUiState(forceList = getForceList())
        //TODO setup a reset block see part 5: https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-viewmodel-and-state#4
        // resetScreen
    }

}

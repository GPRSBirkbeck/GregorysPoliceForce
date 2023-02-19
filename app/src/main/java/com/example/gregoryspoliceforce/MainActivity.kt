package com.example.gregoryspoliceforce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GregorysPoliceForceTheme {
                val viewModel: PoliceViewModel =
                    viewModel(factory = PoliceViewModel.Factory)
                PoliceApp(viewModel)
            }
        }
    }
}

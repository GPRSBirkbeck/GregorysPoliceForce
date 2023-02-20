package com.example.gregoryspoliceforce.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GregorysPoliceForceTheme {
                val viewModel: PoliceViewModel by viewModels()
                PoliceApp(viewModel)
            }
        }
    }
}

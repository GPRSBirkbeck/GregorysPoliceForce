package com.example.gregoryspoliceforce

import android.app.Application
import com.example.gregoryspoliceforce.data.AppContainer
import com.example.gregoryspoliceforce.data.DefaultAppContainer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GregorysPoliceForceApplication: Application() {
    //lateinit var container: AppContainer
//    override fun onCreate() {
//        super.onCreate()
//        //container = DefaultAppContainer()
//    }
}
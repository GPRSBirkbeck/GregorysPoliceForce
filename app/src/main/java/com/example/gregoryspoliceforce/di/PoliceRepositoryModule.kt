package com.example.gregoryspoliceforce.di

import com.example.gregoryspoliceforce.state.DefaultPoliceRepository
import com.example.gregoryspoliceforce.state.PoliceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PoliceRepositoryModule{
        @Binds
        abstract fun bindPoliceRepository(impl: DefaultPoliceRepository): PoliceRepository
}

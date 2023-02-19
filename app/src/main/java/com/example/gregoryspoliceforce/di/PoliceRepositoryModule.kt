package com.example.gregoryspoliceforce.di

import com.example.gregoryspoliceforce.data.DefaultPoliceRepository
import com.example.gregoryspoliceforce.data.PoliceRepository
import com.example.gregoryspoliceforce.network.PoliceApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class PoliceRepositoryModule{
        @Binds
        abstract fun bindPoliceRepository(impl: DefaultPoliceRepository): PoliceRepository
}

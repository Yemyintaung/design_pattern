package com.sbs.android.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

/*@Module
@InstallIn(ViewModelComponent::class)
class PersistenceModule {
    @Provides
    @ViewModelScoped
    fun provideDataStoreManager(@ApplicationContext context: Context): AppDataStoreManager {
        return AppDataStoreManager(context)
    }
}*/

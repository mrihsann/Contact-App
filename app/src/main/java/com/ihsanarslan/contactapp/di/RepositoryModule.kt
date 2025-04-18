package com.ihsanarslan.contactapp.di

import com.ihsanarslan.contactapp.data.local.ContactDao
import com.ihsanarslan.contactapp.domain.repository.ContactDaoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideContactDaoRepositoryImpl(contactDao: ContactDao): ContactDaoRepositoryImpl {
        return ContactDaoRepositoryImpl(contactDao)
    }

}
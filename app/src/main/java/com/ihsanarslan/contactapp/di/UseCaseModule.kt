package com.ihsanarslan.contactapp.di

import com.ihsanarslan.contactapp.domain.repository.ContactDaoRepositoryImpl
import com.ihsanarslan.contactapp.domain.usecase.GetAllContactsUseCase
import com.ihsanarslan.contactapp.domain.usecase.InsertContactUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object UseCaseModule {


    @Provides
    @Singleton
    fun provideInsertContactUseCase(repositoryImpl: ContactDaoRepositoryImpl) : InsertContactUseCase {
        return InsertContactUseCase(repositoryImpl)
    }

    @Provides
    @Singleton
    fun provideGetAllContactsUseCase(repositoryImpl: ContactDaoRepositoryImpl) : GetAllContactsUseCase {
        return GetAllContactsUseCase(repositoryImpl)
    }

}
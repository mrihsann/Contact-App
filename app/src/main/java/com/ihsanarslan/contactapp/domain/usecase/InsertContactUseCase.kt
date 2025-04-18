package com.ihsanarslan.contactapp.domain.usecase

import com.ihsanarslan.contactapp.data.local.ContactEntity
import com.ihsanarslan.contactapp.domain.repository.ContactDaoRepositoryImpl
import javax.inject.Inject

class InsertContactUseCase @Inject constructor(
    private val repository: ContactDaoRepositoryImpl
) {

    suspend operator fun invoke(contact: ContactEntity){
        repository.insertContact(contact)
    }

}
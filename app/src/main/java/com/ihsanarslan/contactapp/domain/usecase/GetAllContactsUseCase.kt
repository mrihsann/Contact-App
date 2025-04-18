package com.ihsanarslan.contactapp.domain.usecase

import androidx.lifecycle.LiveData
import com.ihsanarslan.contactapp.data.local.ContactEntity
import com.ihsanarslan.contactapp.domain.repository.ContactDaoRepositoryImpl
import javax.inject.Inject

class GetAllContactsUseCase @Inject constructor(
    private val repositoryImpl: ContactDaoRepositoryImpl
) {

    operator fun invoke() : LiveData<List<ContactEntity>> {
        return repositoryImpl.getAllContacts()
    }
}
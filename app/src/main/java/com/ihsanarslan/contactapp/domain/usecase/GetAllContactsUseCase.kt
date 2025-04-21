package com.ihsanarslan.contactapp.domain.usecase

import com.ihsanarslan.contactapp.data.local.ContactEntity
import com.ihsanarslan.contactapp.domain.repository.ContactDaoRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllContactsUseCase @Inject constructor(
    private val repositoryImpl: ContactDaoRepositoryImpl
) {

    operator fun invoke() : Flow<List<ContactEntity>> {
        return repositoryImpl.getAllContacts()
    }
}
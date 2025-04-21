package com.ihsanarslan.contactapp.domain.usecase

import com.ihsanarslan.contactapp.data.local.ContactEntity
import com.ihsanarslan.contactapp.domain.repository.ContactDaoRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetContactByIdUseCase @Inject constructor(
    private val repository: ContactDaoRepositoryImpl
) {
    operator fun invoke(id: Int) : Flow<ContactEntity> {
        return repository.getContactById(id)
    }
}
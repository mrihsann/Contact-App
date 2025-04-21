package com.ihsanarslan.contactapp.domain.repository

import androidx.lifecycle.LiveData
import com.ihsanarslan.contactapp.data.local.ContactDao
import com.ihsanarslan.contactapp.data.local.ContactEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContactDaoRepositoryImpl @Inject constructor(
    private val contactDao: ContactDao
) {

    suspend fun insertContact(contact: ContactEntity) {
        contactDao.insertContact(contact)
    }

    fun getAllContacts(): Flow<List<ContactEntity>> = flow {
         val contacts = contactDao.getAllContacts()
        contacts.collect { value ->
            emit(value)
        }
    }

    suspend fun getContactById(id: Int): ContactEntity {
        return contactDao.getContactById(id)
    }

    suspend fun deleteContactById(id: Int) {
        contactDao.deleteContactById(id)
    }

}
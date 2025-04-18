package com.ihsanarslan.contactapp.domain.repository

import androidx.lifecycle.LiveData
import com.ihsanarslan.contactapp.data.local.ContactDao
import com.ihsanarslan.contactapp.data.local.ContactEntity
import javax.inject.Inject

class ContactDaoRepositoryImpl @Inject constructor(
    private val contactDao: ContactDao
) {

    suspend fun insertContact(contact: ContactEntity) {
        contactDao.insertContact(contact)
    }

    fun getAllContacts(): LiveData<List<ContactEntity>> {
        return contactDao.getAllContacts()
    }

    suspend fun getContactById(id: Int): ContactEntity {
        return contactDao.getContactById(id)
    }

    suspend fun deleteContactById(id: Int) {
        contactDao.deleteContactById(id)
    }

}
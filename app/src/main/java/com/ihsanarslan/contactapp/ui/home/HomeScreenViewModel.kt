package com.ihsanarslan.contactapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ihsanarslan.contactapp.data.local.ContactEntity
import com.ihsanarslan.contactapp.domain.repository.ContactDaoRepositoryImpl
import com.ihsanarslan.contactapp.domain.usecase.GetAllContactsUseCase
import com.ihsanarslan.contactapp.domain.usecase.InsertContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllContactsUseCase: GetAllContactsUseCase,
    private val insertContactUseCase: InsertContactUseCase
) : ViewModel() {

    val recentAdded = getAllContactsUseCase()

    val allContacts = getAllContactsUseCase()

    fun insert(contact: ContactEntity) {
        viewModelScope.launch {
            insertContactUseCase(contact)
        }
    }

}
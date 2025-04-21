package com.ihsanarslan.contactapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ihsanarslan.contactapp.data.local.ContactEntity
import com.ihsanarslan.contactapp.domain.usecase.GetAllContactsUseCase
import com.ihsanarslan.contactapp.domain.usecase.InsertContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllContactsUseCase: GetAllContactsUseCase,
    private val insertContactUseCase: InsertContactUseCase
) : ViewModel() {

    private val _allContact = MutableStateFlow<List<ContactEntity>>(emptyList())
    val allContact : StateFlow<List<ContactEntity>>
        get() = _allContact.asStateFlow()

    private val _recentAdded = MutableStateFlow<List<ContactEntity>>(emptyList())
    val recentAdded : StateFlow<List<ContactEntity>>
        get() = _recentAdded.asStateFlow()


    init {
        getAllContact()
    }

    fun getAllContact(){
        viewModelScope.launch {
            getAllContactsUseCase.invoke().collect { value ->
                _allContact.value = value
                _recentAdded.value = value
            }
        }
    }


    fun insert(contact: ContactEntity) {
        viewModelScope.launch {
            insertContactUseCase(contact)
        }
    }

}
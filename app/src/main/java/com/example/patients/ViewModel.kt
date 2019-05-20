package com.example.patients

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _patients = MutableLiveData<List<Patients>>()
    val patitents: LiveData<List<Patients>> = _patients

    fun load() {
        viewModelScope.launch {
            val patientsList = WebAccess.partsApi.getPatients()
            _patients.postValue(patientsList)
        }
    }
}
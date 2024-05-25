package com.example.doorapp.UI.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doorapp.data.DoorRepository

class ViewModelFactory(
    private val repository: DoorRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DoorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DoorViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
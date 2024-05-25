package com.example.doorapp.UI.ViewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doorapp.data.Door
import com.example.doorapp.data.DoorRepository
import kotlinx.coroutines.launch

class DoorViewModel(private val repository: DoorRepository): ViewModel() {
    private val _doors = MutableLiveData<List<Door>>()
    val doors: LiveData<List<Door>> get() = _doors

    fun loadDoors() {
        viewModelScope.launch {
            _doors.value = repository.getAllDoor()
        }
    }

    fun loadByName() {
        viewModelScope.launch {
            _doors.value = repository.getAllDoorOrderByName()
        }
    }

    fun loadByStatus() {
        viewModelScope.launch {
            _doors.value = repository.getAllDorrOrderByStatus()
        }
    }

    fun upsertDoor(door: Door){
        viewModelScope.launch {
            repository.upsertDoor(door)
        }
    }

    fun deleteDoor(door: Door){
        viewModelScope.launch {
            repository.deleteDoor(door)
        }
    }


}
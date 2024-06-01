package com.example.doorapp.data

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class DoorRepository (context : Context){

    private val doorDao: DoorDao = DoorDatabase.getDatabase(context).doorDao()

    val allDoor: LiveData<List<Door>> = doorDao.getAllDoors()
    suspend fun upsertDoor(door: Door) {
        doorDao.upsertDoor(door)
    }

//    suspend fun getAllDoor(): List<Door> {
//        return doorDao.getAllDoors()
//    }
//
//    suspend fun getAllDoorOrderByName(): List<Door> {
//        return doorDao.getContactOrderByName()
//    }
//
//    suspend fun getAllDorrOrderByStatus(): List<Door> {
//        return doorDao.getAllDoorsSortedByLockStatusAsc()
//    }

    suspend fun deleteDoor(door: Door) {
        doorDao.deleteDoor(door)
    }
}
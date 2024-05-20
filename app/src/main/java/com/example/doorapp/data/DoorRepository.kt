package com.example.doorapp.data

import android.content.Context
import kotlinx.coroutines.flow.Flow

class DoorRepository (context : Context){

    private val doorDao: DoorDao = DoorDatabase.getDatabase(context).doorDao()

    suspend fun upsertDoor(door: Door) {
        doorDao.upsertDoor(door)
    }

    suspend fun getAllDoor(): Flow<List<Door>> {
        return doorDao.getAllDoors()
    }

    suspend fun getAllDoorOrderByName(): Flow<List<Door>> {
        return doorDao.getContactOrderByName()
    }

    suspend fun getAllDorrOrderByStatus(): Flow<List<Door>> {
        return doorDao.getAllDoorsSortedByLockStatusAsc()
    }

    suspend fun deleteDoor(door: Door) {
        doorDao.deleteDoor(door)
    }
}
package com.example.doorapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DoorDao {

    @Upsert
    suspend fun upsertDoor (door: Door)

    @Delete
    suspend fun deleteDoor (door: Door)

    @Query("SELECT * FROM Door")
    fun getAllDoors(): LiveData<List<Door>>

    @Query("SELECT * FROM Door ORDER BY name ASC")
    fun getContactOrderByName() : LiveData<List<Door>>

    @Query("SELECT * FROM Door ORDER BY isLocked ASC")
    fun getAllDoorsSortedByLockStatusAsc(): LiveData<List<Door>>
}
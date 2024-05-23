package com.example.doorapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DoorDao {

    @Upsert
    fun upsertDoor (door: Door)

    @Delete
    fun deleteDoor (door: Door)

    @Query("SELECT * FROM Door")
    fun getAllDoors(): Flow<List<Door>>

    @Query("SELECT * FROM Door ORDER BY name ASC")
    fun getContactOrderByName() : Flow<List<Door>>

    @Query("SELECT * FROM Door ORDER BY isLocked ASC")
    fun getAllDoorsSortedByLockStatusAsc(): Flow<List<Door>>
}
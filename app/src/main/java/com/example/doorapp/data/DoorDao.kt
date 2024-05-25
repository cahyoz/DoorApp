package com.example.doorapp.data

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
    suspend fun getAllDoors(): List<Door>

    @Query("SELECT * FROM Door ORDER BY name ASC")
    suspend fun getContactOrderByName() : List<Door>

    @Query("SELECT * FROM Door ORDER BY isLocked ASC")
    suspend fun getAllDoorsSortedByLockStatusAsc(): List<Door>
}
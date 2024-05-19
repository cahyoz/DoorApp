package com.example.doorapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Door::class],
    version = 1
)

abstract class DoorDatabase: RoomDatabase() {
    abstract val dao: DoorDao
}
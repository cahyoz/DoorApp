package com.example.doorapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Door::class],
    version = 1
)

abstract class DoorDatabase: RoomDatabase() {
    abstract fun doorDao(): DoorDao

    companion object {
        @Volatile
        private var INSTANCE: DoorDatabase? = null

        fun getDatabase(context: Context): DoorDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DoorDatabase::class.java,
                    "door_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
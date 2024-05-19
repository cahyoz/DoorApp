package com.example.doorapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Door(
    var name : String,
    var isLocked : Boolean,
    @PrimaryKey(autoGenerate = true)
    var id : Int

)

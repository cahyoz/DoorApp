package com.example.doorapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Door(
    var name : String,
    var isLocked : Boolean = false,
    val lockMethod: LockMethod,
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
) : Parcelable

enum class LockMethod {
    SIMPLE,
    ADVANCE
}

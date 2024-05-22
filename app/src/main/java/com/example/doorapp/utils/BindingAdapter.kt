package com.example.doorapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.doorapp.R

@BindingAdapter("lockStatus")
fun setLockStatus(imageview : ImageView, lockstatus : Boolean) {
    if (lockstatus) {
        imageview.setImageResource(R.drawable.ic_lock)
    } else {
        imageview.setImageResource(R.drawable.ic_unlock)
    }
}
package com.example.doorapp.UI.Activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.doorapp.R
import com.example.doorapp.UI.ViewModel.DoorViewModel
import com.example.doorapp.UI.ViewModel.ViewModelFactory
import com.example.doorapp.data.Door
import com.example.doorapp.data.DoorRepository
import com.example.doorapp.databinding.ActivityDoorDetailBinding

class DoorDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoorDetailBinding
    private lateinit var doorViewModel: DoorViewModel
    private lateinit var door: Door

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = DoorRepository(this)
        val factory = ViewModelFactory(repository)

        door = intent.getParcelableExtra<Door>(EXTRA_DOOR) ?: return

        doorViewModel = ViewModelProvider(this, factory).get(DoorViewModel::class.java)

        binding.btnDeleteDoor.setOnClickListener { view ->
            doorViewModel.deleteDoor(door)
            finish()
        }
    }

    companion object {
        const val EXTRA_DOOR = "key_id"
    }

}
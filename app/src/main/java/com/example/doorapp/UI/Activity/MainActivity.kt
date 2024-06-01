package com.example.doorapp.UI.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doorapp.UI.ViewModel.DoorViewModel
import com.example.doorapp.UI.ViewModel.ViewModelFactory
import com.example.doorapp.UI.fragment.AddDoorBottomSheetFragment
import com.example.doorapp.data.Door
import com.example.doorapp.data.DoorRepository
import com.example.doorapp.databinding.ActivityMainBinding
import com.example.doorapp.utils.DoorListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var addDoorBottomSheetFragment: AddDoorBottomSheetFragment
    private lateinit var doorViewModel: DoorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = DoorRepository(this)
        val factory = ViewModelFactory(repository)

        val layoutManager = LinearLayoutManager(this)
        binding.rvDoor.layoutManager = layoutManager

        doorViewModel = ViewModelProvider(this, factory).get(DoorViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            addDoorBottomSheetFragment = AddDoorBottomSheetFragment()
            addDoorBottomSheetFragment.show(supportFragmentManager, "AddDoorBottomSheetFragment")
            }

//        doorViewModel.loadDoors()
        doorViewModel.doors.observe(this, Observer {
            setDoorData(it)
        })

        }

    private fun setDoorData(doorList : List<Door>) {
        val adapter = DoorListAdapter(doorList)
        binding.rvDoor.adapter = adapter
        binding.rvDoor.visibility = View.VISIBLE
    }
    }




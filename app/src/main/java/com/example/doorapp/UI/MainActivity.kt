package com.example.doorapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doorapp.R
import com.example.doorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var addDoorBottomSheetFragment: AddDoorBottomSheetFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAdd.setOnClickListener {
            addDoorBottomSheetFragment = AddDoorBottomSheetFragment()
            addDoorBottomSheetFragment.show(supportFragmentManager, "AddDoorBottomSheetFragment")
            }
        }
    }




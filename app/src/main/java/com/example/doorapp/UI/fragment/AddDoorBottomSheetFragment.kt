package com.example.doorapp.UI.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.doorapp.R
import com.example.doorapp.UI.ViewModel.DoorViewModel
import com.example.doorapp.data.Door
import com.example.doorapp.data.LockMethod
import com.example.doorapp.databinding.FragmentAddDoorBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class AddDoorBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentAddDoorBottomSheetBinding? = null
    private val binding get() = _binding!!

    private val doorVIewModel: DoorViewModel by activityViewModels()
    private var selectedLockType : LockMethod = LockMethod.ADVANCE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddDoorBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            addDoor()
        }

    }

    private fun addDoor() {
        val doorName = binding.textInputEditTextDoorName.text.toString()
        val selectedLockType = when (binding.rdgroup.checkedRadioButtonId) {
            R.id.btn_simple -> LockMethod.SIMPLE
            R.id.btn_advance -> LockMethod.ADVANCE
            else -> null
        }

        if (doorName.isBlank() || selectedLockType == null) {
            Snackbar.make(binding.root, "Please enter all details", Snackbar.LENGTH_SHORT).show()
            return
        }

        val newDoor = Door(name = doorName, lockMethod = selectedLockType, isLocked = false)
        doorVIewModel.upsertDoor(newDoor)

        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
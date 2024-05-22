package com.example.doorapp.utils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doorapp.data.Door
import com.example.doorapp.databinding.DoorItemBinding

class DoorListAdapter(private val listDoor: ArrayList<Door>) : RecyclerView.Adapter<DoorListAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
         val binding = DoorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listDoor.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val door = listDoor[position]
        holder.bind(door)
    }

    inner class ListViewHolder(private val binding : DoorItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(door: Door) {
            binding.door = door
            binding.executePendingBindings()
        }
    }
}
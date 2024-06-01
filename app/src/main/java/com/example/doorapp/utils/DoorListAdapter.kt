package com.example.doorapp.utils
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doorapp.UI.Activity.DoorDetailActivity
import com.example.doorapp.data.Door
import com.example.doorapp.databinding.DoorItemBinding

class DoorListAdapter(private val listDoor: List<Door>) : RecyclerView.Adapter<DoorListAdapter.ListViewHolder>(){

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
            binding.tvDoorName.text = door.name
            setLockStatus(binding.imageLock, door.isLocked)
//            binding.executePendingBindings()

            binding.root.setOnClickListener {
                val intentDetail = Intent(itemView.context, DoorDetailActivity::class.java)
                intentDetail.putExtra(DoorDetailActivity.EXTRA_DOOR, door)
                itemView.context.startActivity(intentDetail)
            }


        }
    }
}
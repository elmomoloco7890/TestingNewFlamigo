package com.artemis.prime.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemis.prime.data.FlamingoHolidays
import com.artemis.prime.data.FlamingoHolidaysItem
import com.artemis.prime.databinding.AdapterItemsBinding
import com.artemis.prime.events.FlamingoItemClickListener

class FlamingoHolidayAdapter(
    private val context: Context,
    private val clickListener: FlamingoItemClickListener
    ): RecyclerView.Adapter<FlamingoHolidayAdapter.FlamingoViewHolder>()
{

    private val holList = FlamingoHolidays()

    private lateinit var binding: AdapterItemsBinding

    class FlamingoViewHolder(private var holidayItems: AdapterItemsBinding): RecyclerView.ViewHolder(holidayItems.root){
        fun bind(currentItem: FlamingoHolidaysItem, listener: FlamingoItemClickListener){
            holidayItems.flamingoHolidayItems = currentItem
            holidayItems.flamingoItemsClicked = listener
            holidayItems.executePendingBindings()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateHolidayList(holList: List<FlamingoHolidaysItem>){
        this.holList.clear()
        this.holList.addAll(holList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlamingoViewHolder {
        val inflater = LayoutInflater.from(context)
        val flamingoHolidayBinding = AdapterItemsBinding.inflate(inflater, parent, false)
        binding = flamingoHolidayBinding
        return FlamingoViewHolder(flamingoHolidayBinding)
    }

    override fun getItemCount(): Int = holList.size

    override fun onBindViewHolder(holder: FlamingoViewHolder, position: Int) =
        holder.bind(holList[position], clickListener)
}


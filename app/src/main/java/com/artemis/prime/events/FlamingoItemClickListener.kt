package com.artemis.prime.events

import com.artemis.prime.data.FlamingoHolidaysItem

interface FlamingoItemClickListener {
    fun onItemClicked(flamingoHolidaysItem: FlamingoHolidaysItem)
}
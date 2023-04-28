package com.artemis.prime.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artemis.prime.adapter.FlamingoRepo
import com.artemis.prime.data.FlamingoHolidaysItem

class FlamingoViewModel: ViewModel() {

    private var repo: FlamingoRepo? = null
    private val _allHolidays = MutableLiveData<List<FlamingoHolidaysItem>>()
    val allHolidays: LiveData<List<FlamingoHolidaysItem>> = _allHolidays

    fun getToasty(context: Context, message: String, toastType: Int){
        Toast.makeText(context, message, toastType).show()
    }

    init {
        repo = FlamingoRepo().getInstance()
        repo?.loadHolidays(_allHolidays)
    }

}
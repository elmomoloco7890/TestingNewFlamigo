package com.artemis.prime.adapter


import androidx.lifecycle.MutableLiveData
import com.artemis.prime.data.FlamingoHolidaysItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FlamingoRepo {

    private val dataBaseRef: DatabaseReference = FirebaseDatabase.getInstance().reference

    @Volatile private var repoInstance : FlamingoRepo ?= null

    fun getInstance(): FlamingoRepo{
        return repoInstance ?: synchronized(this){
            val instance = FlamingoRepo()
            repoInstance = instance
            instance
        }

    }

    fun loadHolidays(holidayList: MutableLiveData<List<FlamingoHolidaysItem>>){

        dataBaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               try {
                   val holidayItems: List<FlamingoHolidaysItem> = snapshot.children.map{
                       dataSnapshot ->

                       dataSnapshot.getValue(FlamingoHolidaysItem::class.java)!!
                   }

                   holidayList.postValue(holidayItems)
               }
               catch (e: Exception){
                   e.printStackTrace()
               }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

}
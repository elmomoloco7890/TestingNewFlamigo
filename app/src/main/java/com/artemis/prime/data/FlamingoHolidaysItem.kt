package com.artemis.prime.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FlamingoHolidaysItem(
    val date: String ?= null,
    val name: String ?= null
) : Parcelable
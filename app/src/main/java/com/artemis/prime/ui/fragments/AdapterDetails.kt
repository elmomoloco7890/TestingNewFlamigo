package com.artemis.prime.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemis.prime.R
import com.artemis.prime.databinding.FragmentAdapterDetailsBinding


class AdapterDetails : Fragment() {

    private var binding: FragmentAdapterDetailsBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adapter_details, container, false)
    }


}
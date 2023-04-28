package com.artemis.prime.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artemis.prime.R
import com.artemis.prime.databinding.FragmentAdapterBinding


class AdapterFragment : Fragment() {

    private var binding: FragmentAdapterBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val adapterBinding = FragmentAdapterBinding.inflate(inflater, container, false)
        binding = adapterBinding
        return adapterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            adapterFragment = this@AdapterFragment
        }
    }


}
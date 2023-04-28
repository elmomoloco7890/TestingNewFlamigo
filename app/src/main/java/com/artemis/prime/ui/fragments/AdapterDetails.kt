package com.artemis.prime.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemis.prime.R
import com.artemis.prime.databinding.FragmentAdapterDetailsBinding


class AdapterDetails : Fragment() {

    private var binding: FragmentAdapterDetailsBinding ?= null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        val detailsBinding = FragmentAdapterDetailsBinding.inflate(inflater, container, false)
        binding = detailsBinding

        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        if (bundle == null){
            Log.d("Confirmation", "Detail fragment didn't receive info")
            return
        }

        val detailArgs = bundle.let { AdapterDetailsArgs.fromBundle(it) }


        binding?.apply {
            adapterDetailFragment = this@AdapterDetails
            flamingoHolidayItems = detailArgs.flamingoArgs
        }
    }

    fun goHome(){
        findNavController().navigate(R.id.action_adapterDetails_to_homeFragment)
    }

    fun goBackToAdapter(){
        findNavController().navigate(R.id.action_adapterDetails_to_adapterFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}
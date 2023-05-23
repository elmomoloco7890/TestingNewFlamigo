package com.artemis.prime.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.artemis.prime.adapter.FlamingoHolidayAdapter
import com.artemis.prime.data.FlamingoHolidaysItem
import com.artemis.prime.databinding.FragmentAdapterBinding
import com.artemis.prime.events.FlamingoItemClickListener
import com.artemis.prime.model.FlamingoViewModel


class AdapterFragment : Fragment(), FlamingoItemClickListener {

    private var binding: FragmentAdapterBinding ?= null

    private val sharedViewModel: FlamingoViewModel by activityViewModels()

    private lateinit var adapter: FlamingoHolidayAdapter

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
        adapter = FlamingoHolidayAdapter(requireActivity(), this)
        binding?.apply {
            adapterFragment = this@AdapterFragment
            flamingoAdapter = adapter
        }

        sharedViewModel.allHolidays.observe(viewLifecycleOwner) {
            adapter.updateHolidayList(it)
        }

    }
    override fun onItemClicked(flamingoHolidaysItem: FlamingoHolidaysItem) {
        for (holly in 1..30){
            if (holly == 1 ){
                val action = AdapterFragmentDirections.actionAdapterFragmentToAdapterDetails(flamingoHolidaysItem)
                findNavController().navigate(action)
                break
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}
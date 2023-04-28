package com.artemis.prime.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.artemis.prime.R
import com.artemis.prime.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = homeBinding
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            homeFragment = this@HomeFragment
        }
    }

    fun goToAdapter(){
        Toast.makeText(requireActivity(), "Am I clicked", Toast.LENGTH_SHORT).show()
        Log.e("Clicked", "Have I been clicked")
        findNavController().navigate(R.id.action_homeFragment_to_adapterFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}
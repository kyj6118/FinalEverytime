package com.example.afinal.fragmants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.afinal.R
import com.example.afinal.databinding.FragmentClassBinding
import com.example.afinal.databinding.FragmentMapBinding


class MapFragment : Fragment() {
    private lateinit var binding : FragmentMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_map,container,false)


        binding.comTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_mapFragment_to_boardFragment)
        }

        binding.classTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_mapFragment_to_classFragment)
        }
        binding.homeTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_mapFragment_to_homeFragment)
        }

        binding.setTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_mapFragment_to_setFragment)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}



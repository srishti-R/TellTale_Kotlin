package com.srishti.telltale.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.srishti.telltale.MainActivity
import com.srishti.telltale.R
import com.srishti.telltale.StoryViewModel
import com.srishti.telltale.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentFirstBinding = FragmentFirstBinding.inflate(
            inflater, container, false
        )
        val view: View = binding.root
        val model: StoryViewModel =
            ViewModelProvider(activity as MainActivity).get(StoryViewModel::class.java)
        binding.model = model
        binding.optDoggos.setOnClickListener {
            val bundle = bundleOf("num" to 0)
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            model.optionOneSelected(binding.optDoggos)
        }
        binding.optVirgin.setOnClickListener {
            val bundle = bundleOf("num" to 1)
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            model.optionOneSelected(binding.optVirgin)
        }
        binding.optOils.setOnClickListener {
            val bundle = bundleOf("num" to 2)
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
            model.optionOneSelected(binding.optOils)
        }
        return view
    }

}

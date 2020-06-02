package com.srishti.telltale.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.srishti.telltale.MainActivity
import com.srishti.telltale.R
import com.srishti.telltale.StoryViewModel
import com.srishti.telltale.databinding.FragmentStoryBinding

/**
 * A simple [Fragment] subclass.
 */
class StoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentStoryBinding = FragmentStoryBinding.inflate(inflater, container, false)
        val model: StoryViewModel =
            ViewModelProvider(activity as MainActivity).get(StoryViewModel::class.java)
        binding.model = model
        model.formCompleteStory()
        binding.btnRetry.setOnClickListener {
            it.findNavController().navigate(R.id.action_storyFragment_to_firstFragment)
        }
        return binding.root
    }

}

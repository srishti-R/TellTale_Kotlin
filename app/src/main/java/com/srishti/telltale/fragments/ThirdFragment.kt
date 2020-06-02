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
import com.srishti.telltale.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentThirdBinding.inflate(inflater, container, false)
        val view = binding.root
        val model: StoryViewModel =
            ViewModelProvider(activity as MainActivity).get(StoryViewModel::class.java)
        binding.model = model
        val story = binding.btnRead
        story.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_thirdFragment_to_storyFragment)
        }
        binding.optBreak.setOnClickListener { view ->
            model.optionThreeSelected(binding.optBreak)
            binding.lottieCat.visibility = View.VISIBLE
            story.visibility = View.VISIBLE
        }
        binding.optCure.setOnClickListener { view ->
            model.optionThreeSelected(binding.optCure)
            binding.comment.text = getString(R.string.comment_cats_evil)
            binding.lottieCat.visibility = View.VISIBLE
            story.visibility = View.VISIBLE
        }
        return view
    }

}

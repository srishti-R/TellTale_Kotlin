package com.srishti.telltale.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.srishti.telltale.MainActivity
import com.srishti.telltale.R
import com.srishti.telltale.StoryViewModel
import com.srishti.telltale.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    lateinit var model: StoryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(
            inflater, container, false
        )
        val args = arguments?.getInt("num")
        model = ViewModelProvider(activity as MainActivity).get(StoryViewModel::class.java)
        binding.model = model
        binding.flipper.displayedChild = args!!
        binding.optCats.setOnClickListener { view ->
            model.optionTwoSelected(binding.optCats)
            view.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        binding.optAccepted.setOnClickListener {
            model.optionTwoSelected(binding.optAccepted)
            binding.comments1.text = getString(R.string.spot_intro)
            binding.lottieSpot.visibility = View.VISIBLE
        }
        binding.optYou.setOnClickListener {
            model.optionTwoSelected(binding.optYou)
            binding.comments2.text = getString(R.string.comment_gods_pleased)
            binding.btnRead2.visibility = View.VISIBLE
        }
        binding.optSalmon.setOnClickListener {
            model.optionTwoSelected(it as TextView)
            binding.comments2.text = getString(R.string.comment_not_pleased)
            binding.btnRead2.visibility = View.VISIBLE
        }
        binding.optStink.setOnClickListener {
            model.optionTwoSelected(binding.optStink)
            binding.btnRead3.visibility = View.VISIBLE
        }
        binding.optWorks.setOnClickListener {
            model.optionTwoSelected(binding.optWorks)
            binding.btnRead3.visibility = View.VISIBLE
        }
        binding.btnRead2.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_storyFragment)
        }
        binding.btnRead3.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_storyFragment)
        }
        return binding.root
    }
}

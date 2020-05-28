package com.srishti.telltale.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.srishti.telltale.R
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val opt1 = view.opt_doggos
        opt1.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        val opt2 = view.opt_virgin
        opt2.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return view

    }

}

package com.example.task15xml.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.task15xml.R
import com.example.task15xml.databinding.FragmentShowCommentBinding


class ShowCommentFragment : Fragment() {
    val comment = arguments?.getString("comment")
lateinit var binding: FragmentShowCommentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentShowCommentBinding.inflate(layoutInflater)

        return binding.root/**/
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comment = arguments?.getString("comment")
        binding.button2.setOnClickListener {
            parentFragmentManager.popBackStack()

        }
        if (comment != null) {
            binding.textView.text = comment
        }
        binding.textView.text = comment
    }

}
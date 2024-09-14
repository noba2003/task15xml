package com.example.task15xml.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.task15xml.R
import com.example.task15xml.databinding.FragmentTechnologyBinding


class TechnologyFragment : Fragment() {
lateinit var binding: FragmentTechnologyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentTechnologyBinding.inflate(layoutInflater)

        binding.button.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("comment", binding.editTextText.text.toString())
            val showCommentFragment = ShowCommentFragment().apply {
                arguments = bundle
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, showCommentFragment)
                .addToBackStack(null).commit()
        }
        return binding.root
    }



}
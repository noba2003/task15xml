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
import com.example.task15xml.databinding.FragmentWorldBinding


class WorldFragment : Fragment() {

lateinit var binding: FragmentWorldBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentWorldBinding.inflate(layoutInflater)
        binding.button.setOnClickListener {
            sendEmail()
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
    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "message/text"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("noba200397@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, binding.title.text.toString())
            putExtra(Intent.EXTRA_TEXT, binding.editTextText.text.toString())
        }

        try {
            startActivity(Intent.createChooser(intent, "Send email"))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
        }
    }

}
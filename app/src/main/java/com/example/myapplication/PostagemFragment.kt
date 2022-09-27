package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPostagemBinding

class PostagemFragment : Fragment() {

    private lateinit var binding: FragmentPostagemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostagemBinding.inflate(layoutInflater, container, false)

        binding.buttonCancelar.setOnClickListener{
            findNavController().navigate(R.id.action_postagemFragment_to_homeFragment)
        }

        return binding.root
    }
}
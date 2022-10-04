package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.HomeAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Postagem


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        mainViewModel.listPostagem()


        // Configurações do RecyclerView
        val adapter = HomeAdapter()
        binding.recyclerPostagem.layoutManager =  LinearLayoutManager(context)
        binding.recyclerPostagem.adapter = adapter
        binding.recyclerPostagem.setHasFixedSize(true)



        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_postagemFragment)
        }

        mainViewModel.myPostagemResponse.observe(viewLifecycleOwner){
            response -> if (response.body() != null){
                adapter.setList(response.body()!!)
        }
        }

        return binding.root
    }
}
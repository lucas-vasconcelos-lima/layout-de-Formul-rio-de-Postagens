package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.HomeAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.Postagem


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val listGenerica = listOf(
            Postagem(
                "https://d225afdvrjsxie.cloudfront.net/Custom/Content/Products/47/40/47406_dipirona-sodica-50mg-com-100ml-medley_m1_637733730879334040.jpg",
                "Dipirona",
                "Analgésico e antipirético",
                "Medicamento"
            ),

            Postagem(
                "https://cf.shopee.com.br/file/ac1d8e61a8e1388acefe63fe7569daa7",
                "FORMULA INFANTIL NAN COMFOR 1",
                "Fórmula infantil para lactentes de 0 a 6 meses de idade. Com prebióticos, dha, ara e nucleotídeos. Não contém glúten.",
                "Alimentação"
            )
        )





        // Configurações do RecyclerView
        val adapter = HomeAdapter()
        binding.recyclerPostagem.layoutManager =  LinearLayoutManager(context)
        binding.recyclerPostagem.adapter = adapter
        binding.recyclerPostagem.setHasFixedSize(true)

        adapter.setList(listGenerica)


        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_postagemFragment)
        }


        return binding.root
    }
}
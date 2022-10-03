package com.example.myapplication

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        binding.buttonSalvar.setOnClickListener{
            salvar()
        }

        return binding.root
    }

    private fun salvar(){
        val titulo = binding.editNome.text.toString()
        val descricao = binding.editDesc.text.toString()
        val linkImg = binding.editImg.text.toString()

        if(validarCampos(titulo, descricao, linkImg)){
            Toast.makeText(context, "Tarefa Criada!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_postagemFragment_to_homeFragment)
        }else {
            Toast.makeText(context, "Verifique os Campos!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun validarCampos(titulo: String, linkImg: String, desc: String): Boolean{
        return !((titulo == "" || titulo.length < 3 || titulo.length > 20) || Patterns.WEB_URL.matcher(linkImg).matches() || (desc == "" || desc.length < 5 || desc.length > 200))
    }

}
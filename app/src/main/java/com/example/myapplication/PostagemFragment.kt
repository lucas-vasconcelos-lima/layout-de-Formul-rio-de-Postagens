package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPostagemBinding
import com.example.myapplication.model.Categoria
import com.example.myapplication.model.Postagem
import com.example.myapplication.util.MainViewModel

class PostagemFragment : Fragment() {

    private lateinit var binding: FragmentPostagemBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var categoriaSelecionada = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostagemBinding.inflate(layoutInflater, container, false)

        mainViewModel.listCategoria()

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner) {
          response ->  Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())
        }

        binding.buttonSalvar.setOnClickListener {
            inserirNoBanco()
        }

        return binding.root
    }

    fun spinnerCategoria(listCategoria: List<Categoria>?) {
        if (listCategoria != null) {
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                listCategoria
            )

            binding.spinnerCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val selected = binding.spinnerCategoria.selectedItem as Categoria
                    categoriaSelecionada = selected.id
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }


    private fun validarCampos(titulo: String, linkImg: String, desc: String): Boolean {
        return !(
                (titulo == "" || titulo.length < 3 || titulo.length > 20) ||
                        (linkImg == "") ||
                        (desc == "" || desc.length < 5 || desc.length > 200))
    }

    private fun inserirNoBanco() {

        val imagem = binding.editImagem.text.toString()
        val titulo = binding.editTitulo.text.toString()
        val descricao = binding.editDescricao.text.toString()
        val categoria = Categoria(categoriaSelecionada, null, null,null)

        if (validarCampos(titulo, descricao, imagem)) {
            val postagem = Postagem(0, imagem, titulo, descricao, categoria)
            mainViewModel.addPostagem(postagem)
            Toast.makeText(context, "Postagem Criada!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_postagemFragment_to_homeFragment)
        } else {
            Toast.makeText(context, "Verifique os Campos!", Toast.LENGTH_SHORT).show()
        }
    }

}



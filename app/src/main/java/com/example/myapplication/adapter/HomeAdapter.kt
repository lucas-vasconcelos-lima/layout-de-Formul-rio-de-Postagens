package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardLayoutBinding
import com.example.myapplication.model.Postagem

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.PostagemViewHolder>() {

    private var listaPostagem = emptyList<Postagem>()

    class PostagemViewHolder(val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostagemViewHolder {
        return PostagemViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: PostagemViewHolder, position: Int) {
        val postagem = listaPostagem[position]

        holder.binding.textImage.text = postagem.imagem
        holder.binding.textTitulo.text = postagem.titulo
        holder.binding.textDescricao.text = postagem.descricao
        holder.binding.textCategoria.text = postagem.categoria
    }


    override fun getItemCount(): Int {
        return  listaPostagem.size
    }


    fun setList(list: List<Postagem>){

        listaPostagem = list
        notifyDataSetChanged()
    }

}
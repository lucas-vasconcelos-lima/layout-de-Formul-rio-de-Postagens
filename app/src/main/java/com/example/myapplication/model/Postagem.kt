package com.example.myapplication.model

data class Postagem(
    var titulo: String,
    var imagem: String,
    var descricao: String,
    var categoria: Categoria
    //var status: Boolean
) {
}
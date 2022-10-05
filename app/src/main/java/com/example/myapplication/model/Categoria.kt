package com.example.myapplication.model

data class Categoria(
    var id: Long,
    var tipo: String?,
    var descricao: String?,
    var postagem: List<Postagem>?
) {
    override fun toString(): String {
        return descricao!!
    }
}
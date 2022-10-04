package com.example.myapplication.model

data class Categoria(
    var id: Long,
    var tipo: String?,
    var tarefas: List<Postagem>
) {
    override fun toString(): String {
        return tipo!!
    }

}

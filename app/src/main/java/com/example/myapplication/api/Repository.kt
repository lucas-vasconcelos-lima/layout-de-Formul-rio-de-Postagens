package com.example.myapplication.api

import com.example.myapplication.model.Categoria
import com.example.myapplication.model.Postagem
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return  RetrofitInstance.api.listCategoria()
    }
    suspend fun addPostagem(postagem: Postagem): Response<Postagem>{
        return RetrofitInstance.api.addPostagem(postagem)
    }
    suspend fun listPostagem(): Response<List<Postagem>>{
        return RetrofitInstance.api.listPostagem()
    }
 }
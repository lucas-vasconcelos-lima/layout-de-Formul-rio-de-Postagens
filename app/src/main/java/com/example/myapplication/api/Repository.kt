package com.example.myapplication.api

import com.example.myapplication.model.Categoria
import com.example.myapplication.model.Postagem
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return  RetrofitInstance.api.listCategoria()
    }
 }
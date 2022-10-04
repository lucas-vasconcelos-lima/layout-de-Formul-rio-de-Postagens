package com.example.myapplication.api

import com.example.myapplication.model.Categoria
import com.example.myapplication.model.Postagem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("postagem")
    suspend fun addPostagem(@Body postagem: Postagem): Response<Postagem>

    @GET("postagem")
    suspend fun listPostagem(): Response<List<Postagem>>
}
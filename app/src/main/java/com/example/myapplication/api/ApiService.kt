package com.example.myapplication.api

import com.example.myapplication.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categoria")
    suspend fun listCatetoria(): Response<List<Categoria>>

}
package com.example.myapplication.api

import com.example.myapplication.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroFitInstance {

    //INICIALIZAR AS VARIAVEIS TODAS AS VEZES QUE ACESSARMOS ELES
    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    //CLASSE RETROFIT - OBJETO API
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}
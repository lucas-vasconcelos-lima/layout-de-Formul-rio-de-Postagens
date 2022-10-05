package com.example.myapplication.util

import androidx.lifecycle.viewModelScope
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.api.Repository
import kotlinx.coroutines.launch
import com.example.myapplication.model.Categoria
import com.example.myapplication.model.Postagem
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {


    private val _myCategoriaResponse = MutableLiveData<Response<List<Categoria>>>()
    val myCategoriaResponse: LiveData<Response<List<Categoria>>> = _myCategoriaResponse

    private val _myPostagemResponse = MutableLiveData<Response<List<Postagem>>>()
    val myPostagemResponse: LiveData<Response<List<Postagem>>> = _myPostagemResponse

    init {
        //listCategoria()
    }

    fun listCategoria() {
        viewModelScope.launch {
            try {
                val response = repository.listCategoria()
                _myCategoriaResponse.value = response
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun addPostagem(postagem: Postagem){
        viewModelScope.launch {
            try {
                val response = repository.addPostagem(postagem)
                Log.d("Opa", response.body().toString())
                listPostagem()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listPostagem(){
        viewModelScope.launch {
            try {
                val response = repository.listPostagem()
                _myPostagemResponse.value = response
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }
}

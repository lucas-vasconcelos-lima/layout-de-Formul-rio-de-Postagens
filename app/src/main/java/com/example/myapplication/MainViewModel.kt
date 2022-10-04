package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.Repository
import com.example.myapplication.model.Categoria
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {
    //variaveis observáveis


    val repository = Repository()

    private val _myCategoriaResponse = MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> = _myCategoriaResponse

    init {
        listCategoria()
    }

    //MÉTODO RESPONSÁVEL POR TRAZER OS DADOS
    fun listCategoria(){
        viewModelScope.launch {
            try {
                var response = repository.listCategoria()
                _myCategoriaResponse.value = response
            }catch (e: Exception){
                Log.d("Erro", e.message.toString() )
            }
        }
    }

}
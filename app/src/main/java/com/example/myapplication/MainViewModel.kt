package com.example.myapplication
import androidx.lifecycle.viewModelScope
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.api.Repository
import kotlinx.coroutines.launch
import com.example.myapplication.model.Categoria
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    val repository = Repository()


    private val _myCategoriaResponse = MutableLiveData<Response<List<Categoria>>>()
    val myCategoriaResponse: LiveData<Response<List<Categoria>>> = _myCategoriaResponse

    init {
        listCategoria()
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
}

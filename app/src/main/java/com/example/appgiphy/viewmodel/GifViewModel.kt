package com.example.appgiphy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgiphy.model.GifItem
import com.example.appgiphy.api.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class GifViewModel:ViewModel() {

    private val repository = Repository()
    val gif : MutableLiveData <Response <GifItem> > = MutableLiveData()

    fun getGifs(q : String?){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repository.getGifs(q)
            withContext(Dispatchers.Main){
                gif.value = responce
            }
        }
    }

}
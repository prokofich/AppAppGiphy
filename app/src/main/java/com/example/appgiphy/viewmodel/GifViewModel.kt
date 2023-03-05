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

    val Repo = Repository()
    val Gif :MutableLiveData<Response<GifItem>> = MutableLiveData()

    fun get_gifs(q:String?){
        viewModelScope.launch(Dispatchers.IO) {
            var responce = Repo.getgif(q)
            withContext(Dispatchers.Main){
                Gif.value = responce
            }
        }
    }

}
package com.example.appgiphy.api

import com.example.appgiphy.model.GifItem
import retrofit2.Response

class Repository {

    suspend fun getGifs(q:String?):Response<GifItem>{
        return RetrofitInstance.api.getGif(q)
    }

}
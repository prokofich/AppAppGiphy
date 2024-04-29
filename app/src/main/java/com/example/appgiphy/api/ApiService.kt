package com.example.appgiphy.api

import com.example.appgiphy.model.GifItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/gifs/search?api_key=BxRYIZfYLsL7chyLQoedXM6xiNgSoNMO&q=russia&limit=25&offset=0&rating=g&lang=en")
    suspend fun getGif(@Query("q") q : String?) : Response <GifItem>

}
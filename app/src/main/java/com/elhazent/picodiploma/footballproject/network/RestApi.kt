package com.isoneday.footballappapi.network

import com.elhazent.picodiploma.footballproject.mvp.model.ResponseLeague
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("api/v1/json/1/eventspastleague.php")
    fun getLastMatch(@Query("id") leagueid:Int): Call<ResponseLeague>

   @GET("api/v1/json/1/eventsnextleague.php")
    fun getNextMatch(@Query("id") leagueid:Int): Call<ResponseLeague>

}

package com.elhazent.picodiploma.footballproject.mvp.presenter

import android.provider.Contacts
import com.elhazent.picodiploma.footballproject.mvp.model.ResponseLeague
import com.elhazent.picodiploma.footballproject.mvp.view.MainView
import com.isoneday.footballappapi.network.InitRetrofit
import com.isoneday.footballappapi.network.RestApi
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.custom.async
import retrofit2.Call
import retrofit2.Response

class MainPresenter(private val view:MainView) {

    fun getLastmatch(ligaId: Int){
        view.showLoading()
        val api:RestApi = InitRetrofit.getInstance()
        api.getLastMatch(ligaId).enqueue(object : retrofit2.Callback<ResponseLeague>{
            override fun onFailure(call: Call<ResponseLeague>, t: Throwable) {
                view.hideLoading()
                view.errorMessage(t.localizedMessage.toString())
            }

            override fun onResponse(call: Call<ResponseLeague>, response: Response<ResponseLeague>) {
                view.hideLoading()

                    val dataList =  response.body()?.events
                    view.showListItem(dataList)
                    view.showMessage("Berhasil menampilkan data")
            }

        })
    }

    fun getNextmatch(ligaId: Int){
        view.showLoading()
        val api:RestApi = InitRetrofit.getInstance()
        api.getNextMatch(ligaId).enqueue(object : retrofit2.Callback<ResponseLeague>{
            override fun onFailure(call: Call<ResponseLeague>, t: Throwable) {
                view.hideLoading()
                view.errorMessage(t.localizedMessage.toString())
            }

            override fun onResponse(call: Call<ResponseLeague>, response: Response<ResponseLeague>) {
                view.hideLoading()

                val dataList =  response.body()?.events
                view.showListItem(dataList)
                view.showMessage("Berhasil menampilkan data")
            }

        })
    }

}
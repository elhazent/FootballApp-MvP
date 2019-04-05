package com.elhazent.picodiploma.footballproject.mvp.view

import com.elhazent.picodiploma.footballproject.mvp.model.EventsItem

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(isipesan:String)
    fun showListItem(listItem: List<EventsItem>?)
    fun errorMessage(pesanError:String)
}

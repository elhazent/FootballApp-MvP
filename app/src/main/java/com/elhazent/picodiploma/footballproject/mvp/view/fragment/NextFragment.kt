package com.elhazent.picodiploma.footballproject.mvp.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.elhazent.picodiploma.footballproject.R
import com.elhazent.picodiploma.footballproject.mvp.model.EventsItem
import com.elhazent.picodiploma.footballproject.mvp.presenter.MainPresenter
import com.elhazent.picodiploma.footballproject.mvp.view.MainView
import com.isoneday.footballappapi.adapter.ListLeagueAdapter
import kotlinx.android.synthetic.main.fragment_match.*
import kotlinx.android.synthetic.main.fragment_match.view.*
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NextFragment : Fragment(), MainView {

    var mainPresenter: MainPresenter? =null
    val liga:MutableList<EventsItem> = mutableListOf()
    var idliga:Int= 4335
    var listLeagueAdapter: ListLeagueAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_match, container, false)
        v.listfootball.layoutManager = LinearLayoutManager(activity)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainPresenter = MainPresenter(this)
        mainPresenter!!.getNextmatch(idliga)
        listLeagueAdapter = ListLeagueAdapter(liga){

        }
        listfootball.adapter = listLeagueAdapter
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    override fun showMessage(isipesan: String) {
        toast(isipesan)
    }

    override fun showListItem(listItem: List<EventsItem>?) {
        liga.clear()
        if (listItem != null){
            liga.addAll(listItem)
        } else{
            toast("Tidak ada data")
        }
        listLeagueAdapter?.notifyDataSetChanged()
    }

    override fun errorMessage(pesanError: String) {
    }


}

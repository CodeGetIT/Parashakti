package com.parashakti.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.google.gson.Gson
import com.laundromat.others.API_List
import com.laundromat.others.Methods
import com.laundromat.others.MyStateview
import com.laundromat.others.ProgressClickListener
import com.parashakti.R
import com.parashakti.adapter.HomeAdapter
import com.parashakti.databinding.FragmentHomeBinding
import com.parashakti.model.HomeModel
import com.parashakti.others.MyPreferences
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONObject

class HomeFragment : Fragment(),ProgressClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var mStateview: MyStateview
    lateinit var myPreferences: MyPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        mStateview = MyStateview(this, root)
        myPreferences = MyPreferences(root.context)

        getList()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getList() {
        mStateview.showLoading()
        Methods.logPrint("agentid",">>>>>>>>>"+myPreferences.id)
        AndroidNetworking.post(API_List.getactivelist)
            .addBodyParameter("agentid",myPreferences.id)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    var gson = Gson()
                    var homeModel = gson.fromJson<HomeModel>(response.toString(),HomeModel::class.java)
                    Log.e("response", ">>>>>>>>>>>>>>>>>>$response")
                    if (response != null) {
                        mStateview.showContent()
                        var viewRequestAdapter = activity?.let { HomeAdapter(it,homeModel.cases!!) }
                        recyclerview.adapter = viewRequestAdapter
                    } else {
                        mStateview.showContent()
                    }
                }

                override fun onError(error: ANError) {
                    mStateview.showRetry()
                    Log.e("error", ">>>>>>>>" + error.errorDetail)
                }
            })
    }

    override fun onRetryClick() {


    }

}
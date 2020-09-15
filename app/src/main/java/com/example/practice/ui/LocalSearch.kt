package com.example.practice.ui

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.Adapter.CountryAdapter
import com.example.practice.Api.Client
import com.example.practice.Model.BaseResponse
import com.example.practice.Model.CountriesStat
import com.example.practice.ui.LocalSearch
import com.example.practice.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale.filter

class LocalSearch : AppCompatActivity() {
    var mCall  : Call<BaseResponse>?= null
    val TAG = "Country Data"
    var countriesStat = ArrayList<CountriesStat>()
    var CountryAdapter : CountryAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_search)

        CountriesStatApi()
    }
    fun CountriesStatApi()
    {
        mCall = Client.getService().getData("f59d0c32c5msh1ff347ceff08f04p13a92ejsne01ac5b3f079")
        mCall!!.enqueue(responseCallback)
    }
    val responseCallback= object :Callback<BaseResponse>{
        override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
            Log.d(TAG, "onFailure: "+t.localizedMessage)
        }

        override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
           if(response.body() != null)
           {

               if(response.body()!!.countries_stat.size > 0)
               {
                   var total_cases : TextView = findViewById(R.id.total_cases)
                   var new_cases : TextView = findViewById(R.id.new_cases)
                   var total_death : TextView = findViewById(R.id.total_death)
                   var new_death : TextView = findViewById(R.id.new_death)
                   var total_recovred : TextView = findViewById(R.id.total_recovred)

                   val recyclerView : RecyclerView = findViewById(R.id.insuranceType_recyclerview)

                   total_cases.setText(response.body()!!.world_total.total_cases)
                   new_cases.setText(response.body()!!.world_total.new_cases)
                   total_death.setText(response.body()!!.world_total.total_deaths)
                   new_death.setText(response.body()!!.world_total.new_deaths)
                   total_recovred.setText(response.body()!!.world_total.total_recovered)

                   CountryAdapter= CountryAdapter(applicationContext,response.body()!!.countries_stat)
                   recyclerView.layoutManager= LinearLayoutManager(applicationContext)
                   recyclerView.adapter = CountryAdapter
               }
           }
        }

    }

    fun searchFilter()
    {
        val search_filter : EditText = findViewById(R.id.search_filter)

        search_filter.addTextChangedListener( object : TextWatcher{
            override fun afterTextChanged(editable: Editable?) {
                filter(editable.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun filter(text: String) {
        for(s  in  countriesStat)
        {
            if(s.country_name.toLowerCase().contains(text.toLowerCase()))
            {
                countriesStat.add(s)
            }
        }
        CountryAdapter
    }
}
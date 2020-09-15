package com.example.practice.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.Model.CountriesStat
import com.example.practice.R


class CountryAdapter(context: Context, val countriesStat: ArrayList<CountriesStat>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(itemModel : CountriesStat)
        {
            val country_name : TextView = itemView.findViewById(R.id.country_name)
            val country_cases : TextView = itemView.findViewById(R.id.country_cases)
            val country_death : TextView = itemView.findViewById(R.id.country_death)
            val country_recoverd_case : TextView = itemView.findViewById(R.id.country_recoverd_case)
            val country_new_cases : TextView = itemView.findViewById(R.id.country_new_cases)
            val country_new_death : TextView = itemView.findViewById(R.id.country_new_death)

            country_name.setText(itemModel.country_name)
            country_cases.setText(itemModel.cases)
            country_death.setText(itemModel.deaths)
            country_recoverd_case.setText(itemModel.total_recovered)
            country_new_cases.setText(itemModel.new_cases)
            country_new_death.setText(itemModel.new_deaths)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country_data,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return countriesStat.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(countriesStat[position])

        fun filterList(filterdNames: ArrayList<String?>) {
            holder. = filterdNames
            notifyDataSetChanged()
        }
    }

}
package com.example.covidsee

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CovidViewAdapter(var covidList: MutableList<CovidVO>) :
    RecyclerView.Adapter<CovidViewAdapter.CovidHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.covid_item, parent, false)
        return CovidHolder(view)
    }

    override fun getItemCount(): Int = covidList.size


    override fun onBindViewHolder(holder: CovidHolder, position: Int) {
        holder.textCountry.text = covidList[position]?.countryName ?: "null"
        holder.textNewConfirm.text = "신규확진자 수 : ${covidList[position]?.newCase}" ?: "null"
        holder.textConfirmCase.text = "확진자 수 : ${covidList[position]?.totalCase}" ?: "null"
        holder.textRecovered.text = "왼치자 수 : ${covidList[position]?.recovered}" ?: "null"
        holder.textDied.text = "사망자 수 : ${covidList[position]?.death}" ?: "null"
        holder.textPercent.text = "발생률 : ${covidList[position]?.percentage}%" ?: "null"
        holder.textOverseas.text = "전일대비증감-해외유입 : ${covidList[position]?.newFCase}" ?: "null"
        holder.textArea.text = "전일대비증감-지역발생 : ${covidList[position]?.newCCase}" ?: "null"


    }

    class CovidHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var textCountry: TextView = itemView.findViewById(R.id.text_country)
            var textNewConfirm: TextView = itemView.findViewById(R.id.text_new_confirm)
            var textConfirmCase: TextView = itemView.findViewById(R.id.text_confirm_case)
            var textRecovered: TextView = itemView.findViewById(R.id.text_recovered)
            var textDied: TextView = itemView.findViewById(R.id.text_died)
            var textPercent: TextView = itemView.findViewById(R.id.text_percent)
            var textOverseas: TextView = itemView.findViewById(R.id.text_overseas)
            var textArea: TextView = itemView.findViewById(R.id.text_area)
    }
}

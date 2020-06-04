package com.example.anthonyodu.screens.filter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anthonyodu.R
import de.hdodenhof.circleimageview.CircleImageView

class CountryAdapter( var myCountryArray:List<String>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View):RecyclerView.ViewHolder(view) {

        lateinit var countryText:TextView

        fun setCountry(country:String) {
            countryText = itemView.findViewById(R.id.singleCountry)
                countryText.text = country

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myCountryArray.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = myCountryArray[position]
        holder.itemView.context
        holder.setCountry(item)
    }

}
package com.example.anthonyodu.screens.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.FilterListItemBinding
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray


class FilterListAdapter( var myArrayList: FilterArray,private val clickListener: (result: Filter) -> Unit): RecyclerView.Adapter<FilterListAdapter.ViewHolder>()
{

    val viewPool:RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    class ViewHolder(var binding: FilterListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        lateinit var colorRecyclerView: RecyclerView
        lateinit var countryRecyclerView: RecyclerView
        lateinit var noGender:TextView
        lateinit var colorView:TextView
        lateinit var noCountryText:TextView


        fun bind(item:Filter, clickListener: (result: Filter) -> Unit){
            colorRecyclerView = binding.colourRecy
            countryRecyclerView = binding.countryRecy
            noGender = binding.showwhennoGender
            colorView = binding.showwhennocolor
            noCountryText = binding.showwhennocountry
            if(item.gender.isEmpty()){
                noGender.visibility = View.VISIBLE
            }
            if (item.colors.isEmpty()){
                colorView.visibility = View.VISIBLE
            }
            if(item.countries.isEmpty()){
                noCountryText.visibility =View.VISIBLE
            }


            binding.filterList = item
            binding.root.setOnClickListener {
                clickListener(item)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = FilterListItemBinding.inflate(view)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = myArrayList[position]
        holder.bind(myArrayList[position], clickListener)

        val colorLayout = LinearLayoutManager(holder.colorRecyclerView.context,LinearLayoutManager.HORIZONTAL,false)
        val countryLayout = LinearLayoutManager(holder.countryRecyclerView.context,LinearLayoutManager.HORIZONTAL,false)
        colorLayout.initialPrefetchItemCount = item.colors.size
        countryLayout.initialPrefetchItemCount = item.countries.size

        val countryAdapter = CountryAdapter(item.countries)
        val colorAdapter = ColorAdapter(item.colors)

        holder.countryRecyclerView.layoutManager = countryLayout
        holder.colorRecyclerView.layoutManager = colorLayout

        holder.colorRecyclerView.adapter = colorAdapter
        holder.countryRecyclerView.adapter = countryAdapter

        holder.countryRecyclerView.setRecycledViewPool(viewPool)
        holder.colorRecyclerView.setRecycledViewPool(viewPool)

    }


}

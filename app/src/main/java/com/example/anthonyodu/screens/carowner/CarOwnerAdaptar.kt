package com.example.anthonyodu.screens.carowner

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.CarOwnerListItemBinding
import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.CarOwnerList

class CarOwnerAdapter(private var myArrayList: CarOwnerList): RecyclerView.Adapter<CarOwnerAdapter.ViewHolder>(){
    class ViewHolder(var binding: CarOwnerListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CarOwner){
            binding.carOwnerItem = item
            when (item.carColor) {
                "Red" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.circle) .into(binding.smallimage)
                }
                "Green" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.green) .into(binding.smallimage)
                }
                "Violet" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.violet) .into(binding.smallimage)
                }
                "Yellow" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.yellow) .into(binding.smallimage)
                }
                "Blue" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.blue) .into(binding.smallimage)
                }
                "Teal" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.teal) .into(binding.smallimage)

                }
                "Maroon" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.maroon) .into(binding.smallimage)
                }
                "Aquamarine" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.aquamarine) .into(binding.smallimage)
                }
                "Orange" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.orange) .into(binding.smallimage)
                }
                "Mauv" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.mau) .into(binding.smallimage)
                }
                "Puce" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.puce) .into(binding.smallimage)
                }
                "Indigo" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.indigo) .into(binding.smallimage)
                }
                "Turquoise" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.turquoise) .into(binding.smallimage)
                }
                "Goldenrod" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.goldenrod) .into(binding.smallimage)
                }
                "Fuscia" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.fuscia) .into(binding.smallimage)
                }
                "Pink" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.pink) .into(binding.smallimage)
                }
                "Crimson" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.crimson) .into(binding.smallimage)
                }
                "Khaki" -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.khaki) .into(binding.smallimage)
                }
                else -> {
                    Glide.with(binding.root.context).asBitmap().error(R.drawable.login_button).load(
                        R.drawable.black) .into(binding.smallimage)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarOwnerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = CarOwnerListItemBinding.inflate(view)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }

    override fun onBindViewHolder(holder: CarOwnerAdapter.ViewHolder, position: Int) = holder.bind(myArrayList[position])

}
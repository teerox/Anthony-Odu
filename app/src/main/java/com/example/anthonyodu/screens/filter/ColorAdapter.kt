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

class ColorAdapter( var myColorArray:List<String>):RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    class ColorViewHolder(view: View):RecyclerView.ViewHolder(view) {

        lateinit var circleImageView: CircleImageView


        fun setColor(color:String){
            //use the String as color
            circleImageView = itemView.findViewById(R.id.smallSingleImage)


            when(color){
                "Red" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.red).into(circleImageView)
                "Aquamarine" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.aquamarine).into(circleImageView)
                "Orange" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.orange).into(circleImageView)
                "Mauv" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.mau).into(circleImageView)
                "Green" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.green).into(circleImageView)
                "Maroon" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.maroon).into(circleImageView)
                "Violet" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.violet).into(circleImageView)
                "Yellow" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.yellow).into(circleImageView)
                "Blue" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.blue).into(circleImageView)
                "Teal" -> Glide.with(itemView.context).asBitmap().error(R.drawable.login_button).load(R.drawable.teal).into(circleImageView)

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout_color,parent,false)
        return ColorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myColorArray.size
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val item = myColorArray[position]
        holder.itemView.context
        holder.setColor(item)
    }

}
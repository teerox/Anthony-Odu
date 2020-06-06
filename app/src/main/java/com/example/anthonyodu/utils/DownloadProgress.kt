package com.example.anthonyodu.utils


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.*
import android.widget.ProgressBar
import android.widget.TextView
import com.example.anthonyodu.R
import javax.inject.Inject


class DownloadProgress @Inject constructor(private val context: Context){

    var view: View? = null

    //Create UI for Download View
    @SuppressLint("InflateParams")
    fun showDialog(dialog: Dialog) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        view = LayoutInflater.from(context).inflate(R.layout.downloadview,null)
        dialog.setContentView(view!!)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

    }

    //update the UI
    @SuppressLint("SetTextI18n")
    fun update(text:String,percent:Int){
        view?.invalidate()
        val increase = view!!.findViewById<TextView>(R.id.downloadTotal)
        val progress =  view!!.findViewById<ProgressBar>(R.id.progress)
        progress.progressDrawable.setColorFilter(
            Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN)
        progress.progress = percent
        increase.text = "$text%"

    }

    fun dismiss(dialog: Dialog) {
        dialog.dismiss()
    }

}
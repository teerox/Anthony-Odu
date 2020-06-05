package com.example.anthonyodu.utils


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.*
import com.example.anthonyodu.R
import javax.inject.Inject


class DownloadProgress @Inject constructor(private var activity:Context?){

    fun showDialog(dialog: Dialog) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.downloadview)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun dismiss(dialog: Dialog) {
        dialog.dismiss()
    }

}
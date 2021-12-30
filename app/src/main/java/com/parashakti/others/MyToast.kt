package com.laundromat.others

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.parashakti.R

object MyToast {
    fun display(context: Context, message: String?) {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.custom_toast_layout, null)
        val mtoast = Toast(context)
        val tv: TextView = view.findViewById<TextView>(R.id.text)
        tv.setText(message)
      //  mtoast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, 30, 60)
        mtoast.setView(view)
        mtoast.setDuration(Toast.LENGTH_SHORT)
        mtoast.show()
    }
}
package com.parashakti.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parashakti.ForgotPasswordActivity
import com.parashakti.R
import com.parashakti.activity.TestActivity
import com.parashakti.model.HomeModel
import kotlinx.android.synthetic.main.single_row_home.view.*

class HomeAdapter(private val context: Context, val data: List<HomeModel.Case>?) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_row_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var isSelect : Boolean = true
        holder.itemView.tvApplicantName.text = data!![position].fldApplicantName
        holder.itemView.address.text =
            data!![position].fldAltTelephone + "/" + data!![position].fldCaseLocation
        holder.itemView.tvCompany.text = "For : " + data!![position].fldClientCompanyName
        holder.itemView.caseNo.text = "Case No. : " + data!![position].fldCaseNumber
        holder.itemView.tvDate.text = "Date : " + data!![position].fldCreatedOn
        holder.itemView.tvType.text = "Type : " + data!![position].fldCaseType
        holder.itemView.btnTraced.setOnClickListener {
            context.startActivity(Intent(context, TestActivity::class.java))
        }
        holder.itemView.buttonSubmit.setOnClickListener {

            if(isSelect){
                holder.itemView.llBottom.visibility = View.VISIBLE
                isSelect =false;
            }else{
                holder.itemView.llBottom.visibility = View.GONE
                isSelect =true;
            }
        }
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
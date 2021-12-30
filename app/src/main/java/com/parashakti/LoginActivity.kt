package com.parashakti

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener

import com.google.gson.Gson
import com.laundromat.others.API_List
import com.laundromat.others.MyStateview
import com.laundromat.others.MyToast
import com.laundromat.others.ProgressClickListener
import com.parashakti.others.AppUtils
import com.parashakti.others.MyPreferences
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.buttonSubmit
import kotlinx.android.synthetic.main.activity_login.buttonSubmitOtp
import kotlinx.android.synthetic.main.activity_login.constraintLayoutOtp
import kotlinx.android.synthetic.main.activity_login.editTextOtp
import kotlinx.android.synthetic.main.activity_login.editTextPhone
import kotlinx.android.synthetic.main.activity_login.linearLayoutLogin
import kotlinx.android.synthetic.main.activity_login.textViewEditNumber
import kotlinx.android.synthetic.main.activity_login.textViewResend
import org.json.JSONObject

class LoginActivity : AppCompatActivity(), ProgressClickListener {
    private lateinit var retry: String
    lateinit var mStateview: MyStateview
    lateinit var myPreferences: MyPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mStateview = MyStateview(this, null)
        myPreferences = MyPreferences(this)

        tvForgotpassword.setPaintFlags(tvForgotpassword.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
        tvForgotpassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

        buttonSubmit.setOnClickListener {
            if (editTextPhone.text.toString().isEmpty()) {
                Toast.makeText(this@LoginActivity, "Please enter mobile number", Toast.LENGTH_SHORT)
                    .show()
            } else if (editTextPhone.text.toString().length < 1) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter a valid mobile number!",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (edtPassword.text.toString().isEmpty()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                AppUtils.dissmissKeyboard(this@LoginActivity, buttonSubmit)
                login()
            }
        }
    }

    private fun login() {
        mStateview.showLoading()
        AndroidNetworking.post(API_List.login)
            .addBodyParameter("username", editTextPhone.text.toString())
            .addBodyParameter("password", edtPassword.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("response", ">>>>>>>>>>>>>>>>>>>>>$response")
                    if (response != null) {
                        try {
                            mStateview.showContent()

                            MyToast.display(this@LoginActivity, response.getString("message"))
                            myPreferences.login = "1"
                            myPreferences.user_name =
                                response.getJSONObject("user").getString("fld_agent_name")
                            myPreferences.id =
                                response.getJSONObject("user").getString("fld_agent_id")
                            myPreferences.mobile =
                                response.getJSONObject("user").getString("fld_agent_number")
                            myPreferences.email =
                                response.getJSONObject("user").getString("fld_agent_email")
                            myPreferences.agentcode =
                                response.getJSONObject("user").getString("fld_agent_code")

                            Log.e("name",">>>>>>>>"+myPreferences.user_name)
                            startActivity(Intent(this@LoginActivity, MainActivity2::class.java))
                            finishAffinity()
                        } catch (e: Exception) {
                        }
                    } else {
                        mStateview.showContent()
                    }
                }

                override fun onError(error: ANError) {
                    retry = "1"
                    mStateview.showRetry()
                    Log.e("error", ">>>>>>>>" + error.errorDetail)
                }
            })
    }

    override fun onRetryClick() {
        login()
    }
}
package com.parashakti

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_login.*

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        tvLogin.paintFlags = tvForgotpassword.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG
        tvLogin.setOnClickListener {
            finish()
        }
    }
}
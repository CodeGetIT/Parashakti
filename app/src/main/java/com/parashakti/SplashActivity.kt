package com.parashakti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.parashakti.others.MyPreferences

class SplashActivity : AppCompatActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            if (MyPreferences.getActiveInstance(this).login.equals("1", ignoreCase = true)) {
                startActivity(Intent(this@SplashActivity, MainActivity2::class.java))
                finishAffinity()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finishAffinity()
            }
        }, 2000)
    }
}
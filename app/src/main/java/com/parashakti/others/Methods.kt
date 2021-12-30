package com.laundromat.others

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import com.google.android.material.navigation.NavigationView
import com.parashakti.LoginActivity
import com.parashakti.R
import com.parashakti.others.MyPreferences
import java.text.DecimalFormat
import java.util.regex.Pattern

class Methods : ProgressClickListener {
    override fun onRetryClick() {}

    companion object {
        private lateinit var dialog: AlertDialog
        var CURRENCY: String? = null
        /*    fun isOnline(activity: Activity): Boolean {
                val conMgr: ConnectivityManager = activity.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val netInfo: NetworkInfo = conMgr.getActiveNetworkInfo()
                if (netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()) {
                    MyToast.display(activity, "No Internet Connection");
                    return false;
                }return true
            }*/

        fun isOnline(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                        return true
                    }
                }
            }
            return false
        }

        public fun isValidEmailId(email: String): Boolean {
            return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }


        fun hideKeyboardFrom(context: Context, view: View) {
            val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun forceLogoutDialog(activity: Activity) {
            val logoutDialog: AlertDialog = AlertDialog.Builder(activity)
                .setTitle("Another user logged in with this ID")
                .setCancelable(false)
                .setPositiveButton("Logout", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        dialog.dismiss()
                        MyPreferences(activity).clearPreferences()
                        activity.startActivity(Intent(activity, LoginActivity::class.java))
                        activity.finishAffinity()
                    }
                }).create() //.create().show();
            logoutDialog.show()
            val nbutton = logoutDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
            nbutton.setTextColor(activity.getResources().getColor(R.color.colorPrimary))
            val pbutton = logoutDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            pbutton.setTextColor(activity.getResources().getColor(R.color.colorPrimary))
        }

        fun logPrint(name: String?, value: String) {
            Log.e(name, ">>>>>>>>>>>>>>>>>>>>>>>>>$value")
        }

        fun animateNavigationView(
            mActivity: FragmentActivity?,
            contentView: LinearLayout,
            drawer: DrawerLayout, navigationView: NavigationView
        ) {
            drawer.setScrimColor(Color.TRANSPARENT)
            drawer.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
                override fun onDrawerSlide(drawer: View, slideOffset: Float) {
                    //MethodFactory.setNavigationViewAnimation(mActivity, drawer);
                    contentView.setX(navigationView.getWidth() * slideOffset)
                    val lp: DrawerLayout.LayoutParams =
                        contentView.getLayoutParams() as DrawerLayout.LayoutParams
                    lp.height = drawer.height -
                            (drawer.height * slideOffset * 0.3f).toInt()
                    lp.topMargin = (drawer.height - lp.height) / 2
                    contentView.setLayoutParams(lp)
                }

                override fun onDrawerClosed(drawerView: View) {}
            }
            )
        }

        //         NotificationResponser mNotifier = gson.fromJson(serverMessage, NotificationResponser.class);
        /*  public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }*/
        fun showLoginDialog(context: Activity) {
            val logoutDialog: AlertDialog = AlertDialog.Builder(context)
                .setTitle("You are not Logged in.Kindly Login to continue.")
                .setPositiveButton("Login", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        dialog.dismiss()
                        context.startActivity(Intent(context, LoginActivity::class.java))
                        context.finishAffinity()
                    }
                }).setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        dialog.dismiss()
                    }
                }).create() //.create().show();
            logoutDialog.show()
            val nbutton = logoutDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
            nbutton.setTextColor(context.getResources().getColor(R.color.colorPrimary))
            val pbutton = logoutDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            pbutton.setTextColor(context.getResources().getColor(R.color.colorPrimary))

        }

        fun round(number: Double, decimals: Int): String {
            val sb = StringBuilder(decimals + 2)
            sb.append("#.")
            for (i in 0 until decimals) {
                sb.append("0")
            }
            return if (number < 1) {
                "0" + DecimalFormat(sb.toString()).format(number)
            } else {
                DecimalFormat(sb.toString()).format(number)
            }
        }

        public fun logoutDialog(appCompatActivity: Activity) {
            val mBuilder = AlertDialog.Builder(appCompatActivity)
            val mView1: View =
                appCompatActivity.getLayoutInflater().inflate(R.layout.dialog_logout, null)
            val TvExit = mView1.findViewById<TextView>(R.id.TvExit)
            val TvClose = mView1.findViewById<TextView>(R.id.TvClose)
            TvExit.setOnClickListener { dialog.dismiss() }
            TvClose.setOnClickListener {
                dialog.dismiss()
                MyPreferences(appCompatActivity).clearPreferences()
                appCompatActivity.startActivity(
                    Intent(
                        appCompatActivity,
                        LoginActivity::class.java
                    )
                )
                appCompatActivity.finishAffinity()
            }
            mBuilder.setView(mView1)
            dialog = mBuilder.create()
            dialog.show()
        }


    }
}
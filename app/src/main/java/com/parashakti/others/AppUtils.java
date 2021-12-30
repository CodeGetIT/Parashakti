package com.parashakti.others;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.snackbar.Snackbar;
import com.parashakti.R;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {


    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidPassword(CharSequence target) {
        Pattern password = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}$");
        Matcher passwordMactcher = password.matcher(target);
        if (passwordMactcher.matches())
            return true;
        else
            return false;
    }

    public static boolean isValidPhoneNumber(String target) {
        Pattern password = Pattern.compile("^(\\+[\\d]{1,5}|0)?[6-9]\\d{9}$");

        Matcher passwordMactcher = password.matcher(target);
        if (passwordMactcher.matches())
            return true;
        else
            return false;
    }

    public static void showSnack(View view, String message, Context context) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        //snackBarView.setBackgroundColor(context.getResources().getColor(R.color.white));
        TextView tv = snackBarView.findViewById(R.id.snackbar_text);
        tv.setTextColor(context.getResources().getColor(R.color.colorPrimary));

        snackbar.show();
    }

    public static Drawable getTintedDrawableOfColorResId(@NonNull Context context, @NonNull Bitmap inputBitmap, @ColorRes int colorResId) {
        return getTintedDrawable(context, new BitmapDrawable(context.getResources(), inputBitmap), ContextCompat.getColor(context, colorResId));
    }

    public static Drawable getTintedDrawable(@NonNull Context context, @NonNull Drawable inputDrawable, @ColorInt int color) {
        Drawable wrapDrawable = DrawableCompat.wrap(inputDrawable);
        DrawableCompat.setTint(wrapDrawable, color);
        DrawableCompat.setTintMode(wrapDrawable, PorterDuff.Mode.SRC_IN);
        return wrapDrawable;
    }

    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean isMobileDataEnabled(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return mWifi != null && mWifi.isConnected();
    }

    public static boolean isMobileDataEnabled2(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            Class cmClass = Class.forName(cm.getClass().getName());
            Method method = cmClass.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true); // Make the method callable
            // get the setting for "mobile data"
            return (Boolean) method.invoke(cm);
        } catch (Exception e) {
            e.printStackTrace();
            // Some problem accessible private API
            // TODO do whatever error handling you want here
        }
        return false;
    }

    public static boolean isWiFiConnected(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return mWifi != null && mWifi.isConnected();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static final String md5Hash(String s) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(s.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String base64Encode(String text) {
        text.trim();
        byte[] data = text.getBytes(StandardCharsets.UTF_8);
        String base64 = Base64.encodeToString(data, Base64.NO_WRAP);
        base64.trim();
        return base64;
    }

    public static String base64Decode(String base64) {
        base64.trim();
        byte[] data = Base64.decode(base64, Base64.DEFAULT);
        String text = new String(data, StandardCharsets.UTF_8);
        return text;
    }

    public static String getLastPathSegment(String url) {
        Uri uri = Uri.parse(url);
        String token = uri.getLastPathSegment();
        return token;
    }


    public static void dissmissKeyboard(FragmentActivity activity, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

            if (imm.isAcceptingText()) { // verify if the soft keyboard is open
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;
        String phrase = "";
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase += Character.toUpperCase(c);
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase += c;
        }
        return phrase;
    }

    public static String createDate(long timestamp) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        Date d = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(d).toString();
    }


}
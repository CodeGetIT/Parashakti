package com.parashakti.others;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPreferences {
    private static MyPreferences preferences = null;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor editor;
    private String id = "id";
    private String token = "token";
    private String login = "login";
    private String totalprice = "totalprice";
    private String subscription_id = "subscription_id";
    private String subscription_discount = "subscription_discount";
    private String user_name = "user_name";
    private String email = "email";
    private String mobile = "mobile";
    private String lat = "lat";
    private String Long = "long";
    private String wallet = "wallet";
    private String paidAmount = "paidAmount";
    private String currency = "currency";
    private String address = "address";
    private String welcome_screen = "welcome_screen";
    private String sizelist = "sizelist";
    private String colorlist = "colorlist";
    private String brandlist = "brandlist";
    private String vendorlist = "vendorlist";
    private String priceRange = "priceRange";
    private String profile = "profile";
    private String minValue = "minValue";
    private String maxValue = "maxValue";
    private String subscription_check = "subscription_check";
    private String subscription_start = "subscription_start";
    private String subscription_expire = "subscription_expire";
    private String service_fee = "service_fee";
    private String delivery_charge = "delivery_charge";
    private String subscription_amount = "subscription_amount";
    private String subscription_benifit = "subscription_benifit";
    private String agentcode = "agentcode";

    public MyPreferences(Context context) {
        setmPreferences(PreferenceManager.getDefaultSharedPreferences(context));
    }

    public SharedPreferences getmPreferences() {
        return mPreferences;
    }

    public void setmPreferences(SharedPreferences mPreferences) {
        this.mPreferences = mPreferences;
    }


    public static MyPreferences getActiveInstance(Context context) {
        if (preferences == null) {
            preferences = new MyPreferences(context);
        }
        return preferences;
    }

    public void setLogin(String login) {
        editor = mPreferences.edit();
        editor.putString(this.login, login);

        editor.commit();
    }

    public String getLogin() {
        return mPreferences.getString(this.login, "");
    }

    public void setSubscription_check(String subscription_check) {
        editor = mPreferences.edit();
        editor.putString(this.subscription_check, subscription_check);
        editor.commit();
    }

    public String getSubscription_check() {
        return mPreferences.getString(this.subscription_check, "");
    }
    public void setSubscription_start(String subscription_start) {
        editor = mPreferences.edit();
        editor.putString(this.subscription_start, subscription_start);
        editor.commit();
    }

    public String getSubscription_start() {
        return mPreferences.getString(this.subscription_start, "");
    }

    public void setSubscription_expire(String subscription_expire) {
        editor = mPreferences.edit();
        editor.putString(this.subscription_expire, subscription_expire);
        editor.commit();
    }

    public String getService_fee() {
        return mPreferences.getString(this.service_fee, "");
    }

    public void setService_fee(String service_fee) {
        editor = mPreferences.edit();
        editor.putString(this.service_fee, service_fee);
        editor.commit();
    }

    public String getSubscription_amount() {
        return mPreferences.getString(this.subscription_amount, "");
    }

    public void setSubscription_amount(String subscription_amount) {
        editor = mPreferences.edit();
        editor.putString(this.subscription_amount, subscription_amount);
        editor.commit();
    }

    public String getSubscription_benifit() {
        return mPreferences.getString(this.subscription_benifit, "");
    }

    public void setSubscription_benifit(String subscription_benifit) {
        editor = mPreferences.edit();
        editor.putString(this.subscription_benifit, subscription_benifit);
        editor.commit();
    }

    public String getDelivery_charge() {
        return mPreferences.getString(this.delivery_charge, "");
    }

    public void setDelivery_charge(String delivery_charge) {
        editor = mPreferences.edit();
        editor.putString(this.delivery_charge, delivery_charge);
        editor.commit();
    }

    public String getSubscription_expire() {
        return mPreferences.getString(this.subscription_expire, "");
    }

    public void setWelcome_screen(String welcome_screen) {
        editor = mPreferences.edit();
        editor.putString(this.welcome_screen, welcome_screen);

        editor.commit();
    }

    public String getWelcome_screen() {
        return mPreferences.getString(this.welcome_screen, "");
    }

    public void setCurrency(String currency) {
        editor = mPreferences.edit();
        editor.putString(this.currency, currency);

        editor.commit();
    }

    public String getCurrency() {
        return mPreferences.getString(this.currency, "");
    }


    public void setMinValue(String minValue) {
        editor = mPreferences.edit();
        editor.putString(this.minValue, minValue);

        editor.commit();
    }

    public String getMinValue() {
        return mPreferences.getString(this.minValue, "");
    }


    public void setProfile(String profile) {
        editor = mPreferences.edit();
        editor.putString(this.profile, profile);

        editor.commit();
    }

    public String getProfile() {
        return mPreferences.getString(this.profile, "");
    }

    public void setAddress(String address) {
        editor = mPreferences.edit();
        editor.putString(this.address, address);

        editor.commit();
    }

    public String getAddress() {
        return mPreferences.getString(this.address, "");
    }

    public String getToken() {
        return mPreferences.getString(this.token, "");
    }

    public void setToken(String token) {
        editor = mPreferences.edit();
        editor.putString(this.token, token);
        editor.commit();
    }

    public String getSizelist() {
        return mPreferences.getString(this.sizelist, "");
    }

    public void setSizelist(String sizelist) {
        editor = mPreferences.edit();
        editor.putString(this.sizelist, sizelist);
        editor.commit();
    }

    public String getPriceRange() {
        return mPreferences.getString(this.priceRange, "");
    }

    public void setPriceRange(String priceRange) {
        editor = mPreferences.edit();
        editor.putString(this.priceRange, priceRange);
        editor.commit();
    }

    public String getVendorlist() {
        return mPreferences.getString(this.vendorlist, "");
    }

    public void setVendorlist(String vendorlist) {
        editor = mPreferences.edit();
        editor.putString(this.vendorlist, vendorlist);
        editor.commit();
    }

    public String getColorlist() {
        return mPreferences.getString(this.colorlist, "");
    }

    public void setColorlist(String colorlist) {
        editor = mPreferences.edit();
        editor.putString(this.colorlist, colorlist);
        editor.commit();
    }

    public String getBrandlist() {
        return mPreferences.getString(this.brandlist, "");
    }

    public void setBrandlist(String brandlist) {
        editor = mPreferences.edit();
        editor.putString(this.brandlist, brandlist);
        editor.commit();
    }

    public String getLat() {
        return mPreferences.getString(this.lat, "");
    }

    public void setLat(String lat) {
        editor = mPreferences.edit();
        editor.putString(this.lat, lat);
        editor.commit();
    }

    public String getAgentcode() {
        return mPreferences.getString(this.agentcode, "");
    }

    public void setAgentcode(String agentcode) {
        editor = mPreferences.edit();
        editor.putString(this.agentcode, agentcode);
        editor.commit();
    }

    public String getLong() {
        return mPreferences.getString(this.Long, "");
    }

    public void setLong(String Long) {
        editor = mPreferences.edit();
        editor.putString(this.Long, Long);
        editor.commit();
    }

    public String getMaxValue() {
        return mPreferences.getString(this.maxValue, "");
    }

    public void setMaxValue(String maxValue) {
        editor = mPreferences.edit();
        editor.putString(this.maxValue, maxValue);
        editor.commit();
    }

    public String getWallet() {
        return mPreferences.getString(this.wallet, "");
    }

    public void setWallet(String wallet) {
        editor = mPreferences.edit();
        editor.putString(this.wallet, wallet);
        editor.commit();
    }

    public String getUser_name() {
        return mPreferences.getString(this.user_name, "");

    }

    public void setUser_name(String user_name) {
        editor = mPreferences.edit();
        editor.putString(this.user_name, user_name);
        editor.commit();
    }

    public String getPaidAmount() {
        return mPreferences.getString(this.paidAmount, "");

    }

    public void setPaidAmount(String paidAmount) {
        editor = mPreferences.edit();
        editor.putString(this.paidAmount, paidAmount);
        editor.commit();
    }

    public String getEmail() {
        return mPreferences.getString(this.email, "");

    }

    public void setEmail(String email) {
        editor = mPreferences.edit();
        editor.putString(this.email, email);
        editor.commit();
    }


    public String getMobile() {
        return mPreferences.getString(this.mobile, "");

    }

    public void setMobile(String mobile) {
        editor = mPreferences.edit();
        editor.putString(this.mobile, mobile);
        editor.commit();
    }

    public String getTotalprice() {
        return mPreferences.getString(this.totalprice, "");

    }

    public void setTotalprice(String totalprice) {
        editor = mPreferences.edit();
        editor.putString(this.totalprice, totalprice);
        editor.commit();
    }

    public String getSubscription_id() {
        return mPreferences.getString(this.subscription_id, "");

    }

    public void setSubscription_id(String subscription_id) {
        editor = mPreferences.edit();
        editor.putString(this.subscription_id, subscription_id);
        editor.commit();
    }

    public String getSubscription_discount() {
        return mPreferences.getString(this.subscription_discount, "");

    }

    public void setSubscription_discount(String subscription_discount) {
        editor = mPreferences.edit();
        editor.putString(this.subscription_discount, subscription_discount);
        editor.commit();
    }

    public String getId() {
        return mPreferences.getString(this.id, "");
    }

    public void setId(String id) {
        editor = mPreferences.edit();
        editor.putString(this.id, id);
        editor.commit();
    }

    public void clearPreferences() {
        editor = mPreferences.edit();
        editor.clear();
        editor.commit();
    }

}

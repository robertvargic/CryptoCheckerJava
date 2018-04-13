package com.robertvargic.cryptochekerjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Robert Vargic on 19/03/2018.
 */

public class Currency {

    public static final String CURRENCY_ID = "id";
    public static final String CURRENCY_NAME = "name";
    public static final String CURRENCY_SYMBOL = "symbol";
    public static final String CURRENCY_PRICE_USD = "price_usd";
    public static final String CURRENCY_PRICE_BTC = "price_btc";
    public static final String CURRENCY_LAST_UPDATED = "last_updated";

    @Expose
    @SerializedName(CURRENCY_ID)
    public String id;
    @Expose
    @SerializedName(CURRENCY_NAME)
    public String name;
    @Expose
    @SerializedName(CURRENCY_SYMBOL)
    public String symbol;
    @Expose
    @SerializedName(CURRENCY_PRICE_USD)
    public String priceUsd;
    @Expose
    @SerializedName(CURRENCY_PRICE_BTC)
    public String priceBtc;
    @Expose
    @SerializedName(CURRENCY_LAST_UPDATED)
    public Date lastUpdated;
}

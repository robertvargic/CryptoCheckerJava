package com.robertvargic.cryptochekerjava.networking;

import com.robertvargic.cryptochekerjava.models.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v1/ticker/")
    Call<List<Currency>> getCurrencyList();
}

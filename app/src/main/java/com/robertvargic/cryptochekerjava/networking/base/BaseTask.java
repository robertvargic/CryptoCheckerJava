package com.robertvargic.cryptochekerjava.networking.base;

import com.robertvargic.cryptochekerjava.networking.ApiService;

import retrofit2.Retrofit;

public abstract class BaseTask {

    ApiService mService;

    BaseTask(Retrofit retrofit) {
        mService = retrofit.create(ApiService.class);
    }
}

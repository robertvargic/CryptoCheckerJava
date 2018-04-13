package com.robertvargic.cryptochekerjava.networking;

import retrofit2.Call;
import retrofit2.Retrofit;

public abstract class BaseTask<S> {

    protected S mService;
    protected Call mActiveCall;

    protected BaseTask(Retrofit retrofit, Class<S> serviceClass) {
        mService = retrofit.create(serviceClass);
    }

    public void cancel() {
        if (mActiveCall != null) {
            mActiveCall.cancel();
        }
    }
}

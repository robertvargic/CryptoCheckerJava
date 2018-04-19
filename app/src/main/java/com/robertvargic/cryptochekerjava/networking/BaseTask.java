package com.robertvargic.cryptochekerjava.networking;

import retrofit2.Call;
import retrofit2.Retrofit;

public abstract class BaseTask<S> {

    S mService;
    Call mActiveCall;

    BaseTask(Retrofit retrofit, Class<S> serviceClass) {
        mService = retrofit.create(serviceClass);
    }

    public void cancel() {
        if (mActiveCall != null) {
            mActiveCall.cancel();
        }
    }
}

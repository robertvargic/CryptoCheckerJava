package com.robertvargic.cryptochekerjava.networking;

import android.util.Log;

import com.robertvargic.cryptochekerjava.models.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class GetCurrencyListTask extends BaseTask<GetCurrencyListTask.Service> implements ServerTask<List<Currency>, Void> {

    public GetCurrencyListTask(Retrofit retrofit, Class<Service> serviceClass) {
        super(retrofit, Service.class);
    }

    @Override
    public void execute(final TaskListener<List<Currency>> listener, Void... params) {
        if (listener == null) {
            return;
        }
        listener.onPreExecute();
        Call<List<Currency>> call = mService.getCurrencyList();
        mActiveCall = call;
        call.enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                    Log.d("Json received: ", response.raw().toString());
                } else {
                    // TODO: 09/04/2018 retrofit util and readErrorBody method
                    listener.onError(new Exception("networking error on GetCurrencyListTask"));
                }
            }

            @Override
            public void onFailure(Call<List<Currency>> call, Throwable t) {
                listener.onError(t);
            }
        });
    }

    interface Service {
        @GET("v1/ticker/")
        Call<List<Currency>> getCurrencyList();
    }
}

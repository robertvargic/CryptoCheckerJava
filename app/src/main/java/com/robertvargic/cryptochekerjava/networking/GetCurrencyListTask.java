package com.robertvargic.cryptochekerjava.networking;

import android.util.Log;

import com.robertvargic.cryptochekerjava.models.Currency;
import com.robertvargic.cryptochekerjava.networking.base.BaseTask;
import com.robertvargic.cryptochekerjava.networking.base.ServerTask;
import com.robertvargic.cryptochekerjava.networking.base.TaskListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetCurrencyListTask extends BaseTask implements ServerTask<List<Currency>> {

    public GetCurrencyListTask(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    public void execute(final TaskListener<List<Currency>> listener) {
        if (listener == null) {
            return;
        }
        listener.onPreExecute();
        Call<List<Currency>> call = mService.getCurrencyList();
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
}

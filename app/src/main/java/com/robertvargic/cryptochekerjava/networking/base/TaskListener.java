package com.robertvargic.cryptochekerjava.networking.base;

public interface TaskListener<T> {

    void onPreExecute();
    void onSuccess(T result);
    void onError(Throwable error);
}

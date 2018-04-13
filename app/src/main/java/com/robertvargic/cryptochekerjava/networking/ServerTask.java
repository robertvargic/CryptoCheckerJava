package com.robertvargic.cryptochekerjava.networking;

public interface ServerTask<R, P> {

    void execute (TaskListener<R> listener, P... params);
}

package com.robertvargic.cryptochekerjava.networking.base;

public interface ServerTask<R> {

    void execute (TaskListener<R> listener);
}

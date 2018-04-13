package com.robertvargic.cryptochekerjava.ui.base;

import android.os.Bundle;
import android.view.View;

public interface BaseView<T> {

    void setPresenter(T presenter);
    View getRootView();
    Bundle getViewState();
}

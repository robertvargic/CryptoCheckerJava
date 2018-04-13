package com.robertvargic.cryptochekerjava.ui.currencyList;

import android.content.Context;

import com.robertvargic.cryptochekerjava.models.Currency;
import com.robertvargic.cryptochekerjava.ui.base.BasePresenter;
import com.robertvargic.cryptochekerjava.ui.base.BaseView;

import java.util.List;

public interface CurrencyListContract {

    interface View extends BaseView<Presenter> {

        void startLoadingAnimation();

        void stopLoadingAnimation();

        void initListView(List<Currency> currencyList);
    }

    interface Presenter extends BasePresenter {

        void getCurrencyList(Context context);
    }
}

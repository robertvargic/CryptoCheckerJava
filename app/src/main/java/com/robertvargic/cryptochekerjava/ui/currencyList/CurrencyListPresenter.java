package com.robertvargic.cryptochekerjava.ui.currencyList;

import android.content.Context;

import com.robertvargic.cryptochekerjava.models.Currency;
import com.robertvargic.cryptochekerjava.networking.GetCurrencyListTask;
import com.robertvargic.cryptochekerjava.networking.RetrofitUtils;
import com.robertvargic.cryptochekerjava.networking.base.TaskListener;

import org.jetbrains.annotations.NotNull;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyListPresenter implements CurrencyListContract.Presenter {

    private CurrencyListContract.View mCurrencyListView;
    private List<Currency> mCurrencyList;

    public CurrencyListPresenter(@NotNull CurrencyListContract.View view) {
        mCurrencyListView = view;
    }

    @Override
    public void getCurrencyList(Context context) {
        GetCurrencyListTask task = null;
        mCurrencyList = new ArrayList<>();
        try {
            task = new GetCurrencyListTask(RetrofitUtils.createRetrofitForUrl(context));
            task.execute(new TaskListener<List<Currency>>() {
                @Override
                public void onPreExecute() {
                     mCurrencyListView.startLoadingAnimation();
                }

                @Override
                public void onSuccess(List<Currency> result) {
                    mCurrencyList = result;
                    //send result back to view
                    mCurrencyListView.initListView(mCurrencyList);
                    mCurrencyListView.stopLoadingAnimation();
                }

                @Override
                public void onError(Throwable error) {
                    mCurrencyListView.stopLoadingAnimation();
                    error.printStackTrace();
                }
            });
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start() {

    }

}

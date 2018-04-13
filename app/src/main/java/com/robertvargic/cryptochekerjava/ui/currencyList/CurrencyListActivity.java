package com.robertvargic.cryptochekerjava.ui.currencyList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.robertvargic.cryptochekerjava.R;
import com.robertvargic.cryptochekerjava.models.Currency;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Robert Vargic on 17/03/2018.
 */

public class CurrencyListActivity extends AppCompatActivity implements CurrencyListContract.View {

    @BindView(R.id.activity_currency_list_list_view)
    protected ListView mCurrencyListView;

    //presenter
    private CurrencyListContract.Presenter mCurrencyListPresenter;

    private List<Currency> mCurrencyList;
    private CurrencyListAdapter mCurrencyListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);
        ButterKnife.bind(this);
        setPresenter(new CurrencyListPresenter(this));
        mCurrencyListPresenter.getCurrencyList(this);
    }

    @Override
    public void setPresenter(CurrencyListContract.Presenter presenter) {
        mCurrencyListPresenter = presenter;
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }

    @Override
    public void startLoadingAnimation() {

    }

    @Override
    public void stopLoadingAnimation() {

    }

    @Override
    public void initListView(List<Currency> currencyList) {
        mCurrencyList = currencyList;
        mCurrencyListAdapter = new CurrencyListAdapter(mCurrencyList, this);
        mCurrencyListView.setAdapter(mCurrencyListAdapter);
        mCurrencyListAdapter.notifyDataSetChanged();
    }
}

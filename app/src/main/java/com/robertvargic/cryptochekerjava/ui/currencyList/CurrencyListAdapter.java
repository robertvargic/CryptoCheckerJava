package com.robertvargic.cryptochekerjava.ui.currencyList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.robertvargic.cryptochekerjava.R;
import com.robertvargic.cryptochekerjava.models.Currency;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrencyListAdapter extends BaseAdapter {

    private List<Currency> mCurrencyList;
    private Context mContext;
    private LayoutInflater mInflater;

    public CurrencyListAdapter(List<Currency> currencyList, Context context) {
        mContext = context;
        mCurrencyList = currencyList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mCurrencyList.size();
    }

    @Override
    public Object getItem(int i) {
        return mCurrencyList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            view = mInflater.inflate(R.layout.list_item_currency, viewGroup, false);
            viewHolder = new CurrencyListAdapter.ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.currencyTitle.setText(mCurrencyList.get(position).name);
        viewHolder.currencyPrice.setText(mCurrencyList.get(position).priceUsd);

        return view;
    }

    public class ViewHolder{

        @BindView(R.id.list_item_currency_title)
        TextView currencyTitle;
        @BindView(R.id.list_item_currency_price)
        TextView currencyPrice;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

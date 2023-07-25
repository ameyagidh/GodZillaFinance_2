package com.example.godzillafinance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Currency_rv_Adapter extends RecyclerView.Adapter<Currency_rv_Adapter.ViewHolder> {

    private ArrayList<CurrencyRecyclerViewModel> currencyRVModelArrayList;
    private Context context;
    private static DecimalFormat myformat = new DecimalFormat("#.##");

    public Currency_rv_Adapter(ArrayList<CurrencyRecyclerViewModel> currencyRVModelArrayList, Context context) {
        this.currencyRVModelArrayList = currencyRVModelArrayList;
        this.context = context;
    }

    public void filterList(ArrayList<CurrencyRecyclerViewModel>filteredList){
        currencyRVModelArrayList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Currency_rv_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.currency_rv_item,parent,false);
        return new Currency_rv_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Currency_rv_Adapter.ViewHolder holder, int position) {
        CurrencyRecyclerViewModel currencyRvModel = currencyRVModelArrayList.get(position);
        holder.currencyName.setText(currencyRvModel.getName().toString());
        holder.currencyPrice.setText("$" +  myformat.format(currencyRvModel.getPrice()));
        holder.currencySymbol.setText(currencyRvModel.getSymbol().toString());
    }
    @Override
    public int getItemCount() {
        return currencyRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView currencyName;
        private TextView currencyPrice;
        private TextView currencySymbol;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyName = itemView.findViewById(R.id.CurrencyName_rv_item);
            currencyPrice = itemView.findViewById(R.id.Rate_rv_item);
            currencySymbol = itemView.findViewById(R.id.Symbol_rv_item);
        }
    }
}

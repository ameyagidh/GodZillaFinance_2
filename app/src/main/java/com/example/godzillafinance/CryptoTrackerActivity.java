package com.example.godzillafinance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CryptoTrackerActivity extends AppCompatActivity {

    private EditText searchBar;
    private RecyclerView RecyclerViewLayout;
    private ProgressBar ProgressBar_;
    private ArrayList<CurrencyRecyclerViewModel> currencyRVList;
    private Currency_rv_Adapter currency_rv_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_tracker);

        searchBar = findViewById(R.id.SearchCryptoTracker);
        RecyclerViewLayout = findViewById(R.id.recyclerViewCryptoTracker);
        ProgressBar_ = findViewById(R.id.ProgressBarCryptoTracker);

        currencyRVList = new ArrayList<>();
        currency_rv_adapter = new Currency_rv_Adapter(currencyRVList,this);
        RecyclerViewLayout.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewLayout.setAdapter(currency_rv_adapter );
        getCurrencyDataFromApi();

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    filterCurrency( editable.toString());
            }
        });
    }

    private void filterCurrency(String currency){
        ArrayList<CurrencyRecyclerViewModel>filteredList = new ArrayList<>();
        for(CurrencyRecyclerViewModel item : currencyRVList){
            if(item.getName().toLowerCase().contains(currency.toLowerCase())){
                filteredList.add(item );
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(CryptoTrackerActivity.this,"No currency found",Toast.LENGTH_LONG).show();
        }else{
            currency_rv_adapter.filterList(filteredList);
        }
    }

    private void getCurrencyDataFromApi (){
        ProgressBar_.setVisibility(View.VISIBLE);
        String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest  jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ProgressBar_.setVisibility(View.GONE);
                try{
                    JSONArray dataArray = response.getJSONArray("data");
                    for(int i =0; i < dataArray.length(); i++){
                        JSONObject  dataObj = dataArray.getJSONObject(i);
                         String name = dataObj.getString("name");
                         String symbol = dataObj.getString("symbol");
                         JSONObject quote = dataObj.getJSONObject("quote");
                         JSONObject USD = quote.getJSONObject("USD");
                         double price = USD.getDouble("price");
                         currencyRVList.add(new CurrencyRecyclerViewModel(name,symbol,price));
                    }
                    currency_rv_adapter.notifyDataSetChanged();
                }catch(JSONException e){
                    e.printStackTrace();
                    Toast.makeText(CryptoTrackerActivity.this,"Failed to receive data",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CryptoTrackerActivity.this,"Fail to get the data",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> headers = new HashMap<>();
                 headers.put("X-CMC_PRO_API_KEY","79514ef0-0e2e-4e7b-9474-66f8154975f0");
                 return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);

    }

}
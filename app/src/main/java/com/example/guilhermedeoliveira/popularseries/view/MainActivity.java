package com.example.guilhermedeoliveira.popularseries.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guilhermedeoliveira.popularseries.R;
import com.example.guilhermedeoliveira.popularseries.api.SerieService;
import com.example.guilhermedeoliveira.popularseries.model.Serie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String BASE_URL = "https://api.trakt.tv/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // set grid layout
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SerieService service = retrofit.create(SerieService.class);

        Call<Serie> call = service.getPopularSeries();
        call.enqueue(new Callback<Serie>() {
            @Override
            public void onResponse(Call<Serie> call, Response<Serie> response) {

            }

            @Override
            public void onFailure(Call<Serie> call, Throwable t) {

            }
        });

    }
}

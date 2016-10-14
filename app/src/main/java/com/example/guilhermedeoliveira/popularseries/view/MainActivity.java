package com.example.guilhermedeoliveira.popularseries.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.guilhermedeoliveira.popularseries.R;
import com.example.guilhermedeoliveira.popularseries.api.SerieService;
import com.example.guilhermedeoliveira.popularseries.model.Serie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://api.trakt.tv/";
    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

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

        Call<List<Serie>> call = service.getPopularSeries(1, 10);

        call.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Call<List<Serie>> call, Response<List<Serie>> response) {
                if (response.isSuccessful()) {
                    List<Serie> result = response.body();
                    Log.i(TAG, String.format("Series: %s", result.toString()));

                } else {
                    Log.i(TAG, "Erro: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Serie>> call, Throwable t) {
                Log.e(TAG, "Erro: " + t.getMessage());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_share:
                // method
                break;
            case R.id.action_settings:
                // method
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

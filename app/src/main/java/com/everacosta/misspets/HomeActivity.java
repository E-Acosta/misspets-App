package com.everacosta.misspets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.everacosta.misspets.*;

import com.everacosta.misspets.models.ListPets;
import com.everacosta.misspets.models.PetsResponseData;
import com.everacosta.misspets.models.misspetsservices;
import com.everacosta.misspets.utils.preferencesUtils;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    Intent intent;
    misspetsservices misspetsservices;
    private Retrofit retrofit;
    private  String url=config.urlBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.home_activity);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        misspetsservices = retrofit.create(misspetsservices.class);
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.home,true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Log.i("INFO",String.valueOf(id));
                Log.i("INFO","ID HOME:"+String.valueOf(R.id.home));
                Log.i("INFO","ID ADD:"+String.valueOf(R.id.add));
                Log.i("INFO","ID PROFILE:"+String.valueOf(R.id.profile));
                switch (id){
                    case R.id.add:
                        intent = new Intent(HomeActivity.this,AddActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        intent = new Intent(HomeActivity.this,ProfileActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        ChipNavigationBar chipNavigationBar2 = findViewById(R.id.top_nav_bar);
        chipNavigationBar2.setItemSelected(R.id.home,true);
        chipNavigationBar2.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Call<ListPets> call = misspetsservices.listPets("Bearer "+ preferencesUtils.getToken(HomeActivity.this));
                switch (id){
                    case R.id.found:
                        call = misspetsservices.listPetsFound("Bearer "+ preferencesUtils.getToken(HomeActivity.this));
                        break;
                    case R.id.notfound:
                        call = misspetsservices.listPetsNotFound("Bearer "+ preferencesUtils.getToken(HomeActivity.this));
                        break;
                }
                call.enqueue(new Callback<ListPets>() {
                    @Override
                    public void onResponse(Call<ListPets> call, Response<ListPets> response) {
                        RecyclerView recyclerView = findViewById(R.id.recyclePets);
                        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
                        PetsAdapter adapter = new PetsAdapter((ArrayList<PetsResponseData>) response.body().getData(),HomeActivity.this);
                        recyclerView.setAdapter(adapter);
                    }
                    @Override
                    public void onFailure(Call<ListPets> call, Throwable t) {
                    }
                });
            }
        });
        Call<ListPets> call = misspetsservices.listPets("Bearer "+ preferencesUtils.getToken(this));
        call.enqueue(new Callback<ListPets>() {
            @Override
            public void onResponse(Call<ListPets> call, Response<ListPets> response) {
                RecyclerView recyclerView = findViewById(R.id.recyclePets);
                recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));
                PetsAdapter adapter = new PetsAdapter((ArrayList<PetsResponseData>) response.body().getData(),HomeActivity.this);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ListPets> call, Throwable t) {
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.home,true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.home,true);

    }
}

package com.everacosta.misspets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.everacosta.misspets.models.GetProfileResponse;
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

public class ProfileActivity extends AppCompatActivity {
    Intent intent;
    misspetsservices misspetsservices;
    TextView tvFullName,tvEmail;
    private Retrofit retrofit;
    private  String url=config.urlBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.profile,true);
        tvFullName=findViewById(R.id.tvFullName);
        tvEmail=findViewById(R.id.tvEmail);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Log.i("INFO",String.valueOf(id));
                Log.i("INFO","ID HOME:"+String.valueOf(R.id.home));
                Log.i("INFO","ID ADD:"+String.valueOf(R.id.add));
                Log.i("INFO","ID PROFILE:"+String.valueOf(R.id.profile));
                switch (id){
                    case R.id.home:
                        intent = new Intent(ProfileActivity.this,HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.add:
                        intent = new Intent(ProfileActivity.this,AddActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        misspetsservices = retrofit.create(misspetsservices.class);
        Call call = misspetsservices.getProfile("Bearer "+preferencesUtils.getToken(this));
        call.enqueue(new Callback<GetProfileResponse>() {
            @Override
            public void onResponse(Call<GetProfileResponse> call, Response<GetProfileResponse> response) {
                Log.i("INFO",response.body().toString());
                tvFullName.setText(response.body().getGetProfileResponseData().getName()+ " "+response.body().getGetProfileResponseData().getLastname());
                tvEmail.setText(response.body().getGetProfileResponseData().getEmail());
            }

            @Override
            public void onFailure(Call<GetProfileResponse> call, Throwable t) {

            }
        });
        call = misspetsservices.listPetsme("Bearer "+ preferencesUtils.getToken(this));
        call.enqueue(new Callback<ListPets>() {
            @Override
            public void onResponse(Call<ListPets> call, Response<ListPets> response) {
                RecyclerView recyclerView = findViewById(R.id.recyclePets);
                recyclerView.setLayoutManager(new LinearLayoutManager(ProfileActivity.this));
                PetsAdapter adapter = new PetsAdapter((ArrayList<PetsResponseData>) response.body().getData(),ProfileActivity.this);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<ListPets> call, Throwable t) {
            }
        });
    }
    public  void logout(View view){
        preferencesUtils.saveToken(null,ProfileActivity.this);
        Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (preferencesUtils.getToken(this) != null) {
            ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
            chipNavigationBar.setItemSelected(R.id.profile,true);
        }else{
            Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.profile,true);

    }
}

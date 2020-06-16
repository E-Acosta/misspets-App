package com.everacosta.misspets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.everacosta.misspets.models.CreatePetRequest;
import com.everacosta.misspets.models.CreateUserResponse;
import com.everacosta.misspets.models.misspetsservices;
import com.everacosta.misspets.utils.preferencesUtils;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddActivity extends AppCompatActivity {
    Intent intent;
    private com.everacosta.misspets.models.misspetsservices misspetsservices;
    private Retrofit retrofit;
    private String url = config.urlBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        misspetsservices = retrofit.create(com.everacosta.misspets.models.misspetsservices.class);
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.add,true);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Log.i("INFO",String.valueOf(id));
                Log.i("INFO","ID HOME:"+String.valueOf(R.id.home));
                Log.i("INFO","ID ADD:"+String.valueOf(R.id.add));
                Log.i("INFO","ID PROFILE:"+String.valueOf(R.id.profile));
                switch (id){
                    case R.id.home:
                        intent = new Intent(AddActivity.this,HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        intent = new Intent(AddActivity.this,ProfileActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });
    }
    public void registrarPet(View view){
        EditText edName=findViewById(R.id.edPetName);
        EditText edAddress=findViewById(R.id.edAddress);
        EditText edPhone=findViewById(R.id.edPhone);
        EditText edDate=findViewById(R.id.edDate);
        EditText edDescription=findViewById(R.id.edDescription);
        RadioButton cat= findViewById(R.id.radioCat);
        RadioButton Dog= findViewById(R.id.radioDog);
        String type;
        if(cat.isSelected()){
            type="cat";
        }else {
            type="dog";
        }
        CreatePetRequest pet = new CreatePetRequest(edName.getText().toString(),type,edAddress.getText().toString(),edPhone.getText().toString(),edDate.getText().toString(),edDescription.getText().toString());
        Log.i("INFO",pet.toString());
        if(pet.getAddress().length()<1||pet.getName().length()<1||pet.getDescription().length()<1||pet.getDate().length()<1||pet.getPhone().length()<1){
            lanzarAlerta(AddActivity.this, "Data can not be empty");
        }else{
            Call<CreateUserResponse> call = misspetsservices.createPet("Bearer "+ preferencesUtils.getToken(this),pet);
            call.enqueue(new Callback<CreateUserResponse>() {
                @Override
                public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                    if (response.body().isUserRegistered()) {
                        lanzarAlerta(AddActivity.this, "pet Registered");
                        Intent intent = new Intent(AddActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        lanzarAlerta(AddActivity.this, "Date no valid");
                    }
                }

                @Override
                public void onFailure(Call<CreateUserResponse> call, Throwable t) {

                }
            });
        }



    }
    public void lanzarAlerta(Context context, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.add,true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.add,true);

    }
}

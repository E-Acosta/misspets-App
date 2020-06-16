package com.everacosta.misspets;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.everacosta.misspets.models.LoginRequestData;
import com.everacosta.misspets.models.LoginResponse;
import com.everacosta.misspets.models.LoginResponseData;
import com.everacosta.misspets.models.misspetsservices;
import com.everacosta.misspets.utils.preferencesUtils;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private  misspetsservices misspetsservices;
    private Retrofit retrofit;
    private  String url=config.urlBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        misspetsservices = retrofit.create(misspetsservices.class);
        if (preferencesUtils.getToken(this) != null) {
            Log.i("INFO", "tal parece si hay token");
            Log.i("INFO", preferencesUtils.getToken(this));
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);

        } else {
            Log.i("INFO", "tal parece mo hay token");
        }
    }

    public void startRegister(View view){
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
    public  void login(View view){
        EditText edEmail = findViewById(R.id.edEmail);
        EditText edpassword = findViewById(R.id.etPassword);
        String email=edEmail.getText().toString();
        String password=edpassword.getText().toString();
        if(email=="" || password == "" |email==null || password == null || email.length()<1 || password.length()<1){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Data can not be empty");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }else{
            Log.i("INFO", "email: "+email+" pass:"+password);
            LoginRequestData requestData = new LoginRequestData(email,password);
            Log.i("INFO", "email: "+requestData.email+" pass:"+requestData.password);
            Call<LoginResponse> call = misspetsservices.login(requestData);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    Log.e("INFO", "hubo error aqui?"+response.toString());
                    try{
                        if(!response.body().isError()){
                            preferencesUtils.saveToken(response.body().getLoginResponseData().getToken(),MainActivity.this);
                            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }else{
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("Error");
                            alertDialog.setMessage(response.body().getLoginResponseData().getMessage());
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        }
                    }catch (Exception e){
                        Log.i("INFO",e.toString());
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage(response.body().getLoginResponseData().getMessage());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }

                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Log.e("INFO", String.valueOf(t));
                    Log.e("INFO",t.toString());
                }
            });

        }

    }
    protected void onStart() {
        super.onStart();
        if (preferencesUtils.getToken(this) != null) {
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        }
    }
}

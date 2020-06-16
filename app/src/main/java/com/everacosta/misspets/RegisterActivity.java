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

import com.everacosta.misspets.models.CreateUserRequest;
import com.everacosta.misspets.models.CreateUserResponse;
import com.everacosta.misspets.models.LoginResponse;
import com.everacosta.misspets.models.misspetsservices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    private com.everacosta.misspets.models.misspetsservices misspetsservices;
    private Retrofit retrofit;
    private String url = config.urlBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        misspetsservices = retrofit.create(misspetsservices.class);
    }

    public void registerUser(View view) {
        EditText edName = findViewById(R.id.edName);
        EditText edLastName = findViewById(R.id.edLastName);
        EditText edEmail = findViewById(R.id.edEmail);
        EditText edPassword = findViewById(R.id.edPassword);
        EditText edPasswordConfirm = findViewById(R.id.edConfirmPassword);
        CreateUserRequest user = new CreateUserRequest(edName.getText().toString(), edLastName.getText().toString(),edEmail.getText().toString(),edPassword.getText().toString());
        if (user.getName().length() < 1 || user.getLastname().length() < 1 || user.getEmail().length() < 1 || user.getPassword().length() < 1) {
            lanzarAlerta(RegisterActivity.this, "Data can not be empty");
        } else {
            Log.i("INFO","Password Confirm: "+edPasswordConfirm.getText().toString());
            Log.i("INFO","Usuario: "+user.toString());
            if(edPassword.getText().toString().equals(edPasswordConfirm.getText().toString())){
                Call<CreateUserResponse> call = misspetsservices.createUser(user);
                call.enqueue(new Callback<CreateUserResponse>() {
                    @Override
                    public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                        if (response.body().isUserRegistered()) {
                            lanzarAlerta(RegisterActivity.this, "User Registered");
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            lanzarAlerta(RegisterActivity.this, "Email Invalid");
                        }
                    }

                    @Override
                    public void onFailure(Call<CreateUserResponse> call, Throwable t) {

                    }
                });
            }else{
                lanzarAlerta(RegisterActivity.this, "Password not matched");

            }
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
}

package com.everacosta.misspets.models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface misspetsservices {
    @Headers({
            "Content-type: application/json"
    })
    @POST("user/login")
    Call<LoginResponse> login(@Body LoginRequestData data );

    @Headers({
            "Content-type: application/json"
    })
    @GET("user/me")
    Call<GetProfileResponse> getProfile( @Header("Authorization") String token);

    @Headers({
            "Content-type: application/json"
    })
    @POST("user/create")
    Call<CreateUserResponse> createUser(@Body CreateUserRequest data);
    @GET("/pets/list")
    Call<ListPets> listPets( @Header("Authorization") String token);
    @GET("/pets/listme")
    Call<ListPets> listPetsme( @Header("Authorization") String token);
    @GET("/pets/list/true")
    Call<ListPets> listPetsFound( @Header("Authorization") String token);
    @GET("/pets/list/false")
    Call<ListPets> listPetsNotFound( @Header("Authorization") String token);
    @POST("/pets/create")
    Call<CreateUserResponse> createPet(@Header("Authorization") String token,@Body CreatePetRequest data);
}

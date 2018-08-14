package com.example.oilha.restaurantes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRestaurantService {

    @GET("restaurants")
    Call<ArrayList<Restaurants>> BuscarRestaurantes();
}

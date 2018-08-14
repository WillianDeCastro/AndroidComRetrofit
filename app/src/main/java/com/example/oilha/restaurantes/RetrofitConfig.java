package com.example.oilha.restaurantes;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit myRetrofit;

    public RetrofitConfig() {
       this.myRetrofit= new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public IRestaurantService getCEPService() {
        return this.myRetrofit.create(IRestaurantService.class);
    }
}

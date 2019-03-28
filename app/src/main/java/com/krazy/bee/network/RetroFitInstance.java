package com.krazy.bee.network;

import com.krazy.bee.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitInstance {

    private RetroFitInstance() {
    }


    public static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}

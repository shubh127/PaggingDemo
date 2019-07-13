package com.shubham.myapplication;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetroFitClient {

    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";
    private static RetroFitClient mInstace;
    private Retrofit retroFit;

    private RetroFitClient() {
        retroFit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetroFitClient getInstance() {
        if (mInstace == null) {
            mInstace = new RetroFitClient();
        }
        return mInstace;
    }

    public Api getApi() {
        return retroFit.create(Api.class);
    }
}

package com.moringaschool.g_samaritan.network;

import com.moringaschool.g_samaritan.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SamaritanClient {

    private static Retrofit retrofit = null;

    public static SamaritanApi getClient() {

        if (retrofit == null) {
          retrofit = new Retrofit.Builder()//reate new retrofit instance
                  .baseUrl(Constants.G_SAMARITAN_BASE_URL)// Api base url
//                  .client(okHttpClient)
                  .addConverterFactory(GsonConverterFactory.create())// converter
                  .build();
        }
        return  retrofit.create(SamaritanApi.class);

    }
}

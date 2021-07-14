package com.moringaschool.g_samaritan.network;

import com.moringaschool.g_samaritan.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UniversityClient {

    private static Retrofit retrofit = null;

    public static UniApi getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()//reate new retrofit instance
                    .baseUrl(Constants.G_SAMARITAN_BASE_URL)// Api base url
//                  .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())// converter
                    .build();
        }
        return  retrofit.create(UniApi.class);

    }
}

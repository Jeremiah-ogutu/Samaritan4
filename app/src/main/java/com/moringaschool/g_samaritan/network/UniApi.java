package com.moringaschool.g_samaritan.network;


import com.moringaschool.g_samaritan.Universities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UniApi {
    @GET("search?name")
    Call<Universities> getUniversities(
    );
}


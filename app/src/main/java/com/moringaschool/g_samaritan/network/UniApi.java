package com.moringaschool.g_samaritan.network;


import com.moringaschool.g_samaritan.models.Universities;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UniApi {
    @GET("/search")
    Call<List<Universities>> getUniversities(
    );
}


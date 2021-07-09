package com.moringaschool.g_samaritan.network;

import com.moringaschool.g_samaritan.models.GsamaritanResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SamaritanApi {
    @GET("search?name=middle")
    Call<GsamaritanResponse> getLost(
            @Query("county") String county
    );

}

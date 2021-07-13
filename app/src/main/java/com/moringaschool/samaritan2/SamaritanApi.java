package com.moringaschool.samaritan2;


//import android.telecom.Call;
//
import android.telecom.Call;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
//
public interface SamaritanApi {
    @GET("search?name")
    Call<GsamaritanResponse> getLostItems(
            @Query("name") String name
    );
}
//public interface SamaritanApi {
//    @GET("breweries")
//    Call<BreweriesResponse>breweries(
//            @Query("brewery type") String name
//    );
//}

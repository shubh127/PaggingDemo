package com.shubham.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("answers")
    Call<StackApiResponse> getAnswers(
            @Query("page") int pageNumber,
            @Query("pagesize") int pageSize,
            @Query("site") String siteName
            );
}

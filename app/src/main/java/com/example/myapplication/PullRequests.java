package com.example.myapplication;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Hasa on 27-10-2017.
 */

public interface PullRequests {
    @GET("/api/v1/search")
    Observable<PullsResponse> getPulls(@Url String url);
}

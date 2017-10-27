package com.example.myapplication;

import rx.Observable;

/**
 * Created by Hasa on 27-10-2017.
 */

public interface PullRequestsViewInterface {
    void onGetPullsComplete();
    void onGetPullsError(String message);
    void onGetPullsSuccess(PullsResponse result);
    Observable<PullsResponse> getPullRequests(String query);
}

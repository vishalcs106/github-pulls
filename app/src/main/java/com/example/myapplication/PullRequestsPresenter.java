package com.example.myapplication;

import rx.Observer;

/**
 * Created by Hasa on 27-10-2017.
 */

public class PullRequestsPresenter extends BasePresenter implements Observer<PullsResponse> {
    PullRequestsViewInterface viewInterface;

    public PullRequestsPresenter(PullRequestsViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void onCompleted() {
        viewInterface.onGetPullsComplete();
    }

    @Override
    public void onError(Throwable e) {
        viewInterface.onGetPullsError(e.getMessage());
    }

    @Override
    public void onNext(PullsResponse pullsResponse) {
        viewInterface.onGetPullsSuccess(pullsResponse);
    }

    public void getPullRequests(String url){
        unSubscribeAll();
        subscribe(viewInterface.getPullRequests(url), PullRequestsPresenter.this);
    }
}

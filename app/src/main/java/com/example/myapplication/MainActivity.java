package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements PullRequestsViewInterface{
    @BindView(R.id.usernameEditText)
    EditText usernameEditText;
    @BindView(R.id.repoEditText) EditText repoEditText;
    @BindView(R.id.submitButton)
    Button submitButton;
    @BindView(R.id.pullsListRecyclerView)
    RecyclerView pullsRecyclerView;
    PullRequestsPresenter pullRequestsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pullRequestsPresenter = new PullRequestsPresenter(this);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!usernameEditText.getText().toString().equals("") && !repoEditText.getText().toString().equals("")){
                    String url = "/repos/"+
                            usernameEditText.getText().toString()+"/"+
                            repoEditText.getText().toString()+"/pulls";
                    pullRequestsPresenter.getPullRequests(url);
                }
            }
        });
    }

    @Override
    public void onGetPullsComplete() {

    }

    @Override
    public void onGetPullsError(String message) {

    }

    @Override
    public void onGetPullsSuccess(PullsResponse result) {
        System.out.print("");
    }

    @Override
    public Observable<PullsResponse> getPullRequests(String url) {
        return ((App) getApplication()).mRetrofit.create(PullRequests.class).getPulls(url);
    }
}

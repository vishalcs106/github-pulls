package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Hasa on 27-10-2017.
 */

public class PullRequestsListAdapter RecyclerView.Adapter<PullRequestsListAdapter.ViewHolder>{

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView, authorTextView;
    public ViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        authorTextView = itemView.findViewById(R.id.authorTextView);

    }

}

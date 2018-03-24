package com.example.redditdemo.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;

import com.example.redditdemo.R;
import com.example.redditdemo.presenter.RedditDetailPresenter;
import com.example.redditdemo.viewinterface.RedditDetailView;
import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;

import butterknife.ButterKnife;

public class RedditDetailActivity extends MvpActivity<RedditDetailPresenter, RedditDetailView>
        implements RedditDetailView {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reddit_detail);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        progressDialog = new ProgressDialog(this);
    }

    @Override
    protected void onPresenterCreatedOrRestored(RedditDetailPresenter presenter) {

    }

    @Override
    public PresenterFactory<RedditDetailPresenter> getPresenterFactory() {
        return RedditDetailPresenter::new;
    }

    @Override
    public void displayRedditDetail() {

    }

    @Override
    public Context getAndroidContext() {
        return this;
    }

    @Override
    public void showMessage(String msg) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void startLoading(String message) {
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    @Override
    public void stopLoading() {
        progressDialog.dismiss();
    }
}

package com.example.redditdemo.activity;

import android.content.Context;
import android.os.Bundle;

import com.example.redditdemo.R;
import com.example.redditdemo.presenter.HomePresenter;
import com.example.redditdemo.viewinterface.HomeView;
import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;

import butterknife.ButterKnife;

public class HomeActivity extends MvpActivity<HomePresenter, HomeView> implements HomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPresenterCreatedOrRestored(HomePresenter presenter) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().getPopularReddits();
    }

    @Override
    public PresenterFactory<HomePresenter> getPresenterFactory() {
        return HomePresenter::new;
    }

    @Override
    public Context getAndroidContext() {
        return this;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void startLoading(String message) {

    }

    @Override
    public void stopLoading() {

    }
}

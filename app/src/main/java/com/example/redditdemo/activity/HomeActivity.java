package com.example.redditdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.redditdemo.R;
import com.example.redditdemo.adapter.RecyclerViewItemClick;
import com.example.redditdemo.adapter.RedditsListAdapter;
import com.example.redditdemo.model.PopularRedditsResponse;
import com.example.redditdemo.presenter.HomePresenter;
import com.example.redditdemo.utility.Constants;
import com.example.redditdemo.viewinterface.HomeView;
import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends MvpActivity<HomePresenter, HomeView> implements HomeView,
        RecyclerViewItemClick {

    @BindView(R.id.recyclerReddits)
    RecyclerView recyclerReddits;
    @BindView(R.id.swipeRefreshView)
    SwipeRefreshLayout swipeRefreshView;
    private RedditsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        recyclerReddits.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshView.setOnRefreshListener(() -> getPresenter().getPopularReddits());
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
        Snackbar.make(swipeRefreshView, msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void startLoading(String message) {
        swipeRefreshView.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        swipeRefreshView.setRefreshing(false);
    }

    @Override
    public void displayRedditsList(List<PopularRedditsResponse.DataBeanX.ChildrenBean> children) {
        adapter = new RedditsListAdapter(this, children);
        adapter.setItemClick(this);
        recyclerReddits.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder,
                              int position) {
        gotoRedditDetail(this.adapter.getItemAt(position));
    }

    private void gotoRedditDetail(PopularRedditsResponse.DataBeanX.ChildrenBean reddit) {
        final Intent intent = new Intent(this, RedditDetailActivity.class);
        intent.putExtra(Constants.SharedPrefs.REDDIT_ID, reddit.getData().getId());
        startActivity(intent);
    }
}

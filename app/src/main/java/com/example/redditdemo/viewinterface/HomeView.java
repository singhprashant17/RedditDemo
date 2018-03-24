package com.example.redditdemo.viewinterface;

import com.example.redditdemo.model.PopularRedditsResponse;
import com.exmaple.androidmvp.MvpLoadingView;

import java.util.List;

public interface HomeView extends MvpLoadingView {
    void displayRedditsList(List<PopularRedditsResponse.DataBeanX.ChildrenBean> children);
}

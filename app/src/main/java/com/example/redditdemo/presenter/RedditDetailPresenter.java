package com.example.redditdemo.presenter;

import com.example.redditdemo.R;
import com.example.redditdemo.utility.Utility;
import com.example.redditdemo.viewinterface.RedditDetailView;
import com.example.redditdemo.webapi.NoInternetException;
import com.example.redditdemo.webapi.WebService;
import com.exmaple.androidmvp.MvpPresenter;
import com.google.gson.JsonElement;

import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class RedditDetailPresenter implements MvpPresenter<RedditDetailView> {
    private RedditDetailView view;
    private Subscription subscription = Subscriptions.empty();

    @Override
    public void attach(RedditDetailView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view.stopLoading();
        subscription.unsubscribe();
    }

    public void getRedditDetail() {
        subscription = WebService.createService()
                .getRedditDetail()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(() -> {
                    // chk if network available
                    if (!Utility.checkNetwork()) {
                        throw new NoInternetException();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> view.startLoading(view.getAndroidContext().getString(R
                        .string.loading)))
                .doOnError(throwable -> {
                    if (throwable instanceof NoInternetException) {
                        view.showMessage(view.getAndroidContext().getString(R.string.no_internet));
                    }
                })
                .subscribe(new SingleSubscriber<JsonElement>() {
                    @Override
                    public void onSuccess(JsonElement response) {
                        view.stopLoading();
                        view.showMessage(view.getAndroidContext().getString(R.string.success));
                        view.displayRedditDetail();
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.stopLoading();
                        view.showMessage(view.getAndroidContext().getString(R.string.error));
                        error.printStackTrace();
                    }
                });
    }
}

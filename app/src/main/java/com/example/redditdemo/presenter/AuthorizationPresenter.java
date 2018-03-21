package com.example.redditdemo.presenter;

import android.util.Log;

import com.example.redditdemo.utility.Utility;
import com.example.redditdemo.viewinterface.AuthorizationView;
import com.example.redditdemo.webapi.NoInternetException;
import com.example.redditdemo.webapi.WebService;
import com.exmaple.androidmvp.MvpPresenter;
import com.google.gson.JsonElement;

import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

import static com.example.redditdemo.utility.Constants.Url.REDIRECT_URI;

public class AuthorizationPresenter implements MvpPresenter<AuthorizationView> {
    private static final String TAG = AuthorizationPresenter.class.getSimpleName();
    private AuthorizationView view;
    private Subscription subscription = Subscriptions.empty();

    @Override
    public void attach(AuthorizationView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        subscription.unsubscribe();
        view.stopLoading();
    }

    public void authorizeClient(String code) {
        subscription = WebService.createService()
                .authorizeClient("authorization_code", code, REDIRECT_URI)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(() -> {
                    // chk if network available
                    if (!Utility.checkNetwork()) {
                        throw new NoInternetException();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> view.startLoading("Loading"))
                .doOnError(throwable -> {
                    if (throwable instanceof NoInternetException) {
                        view.showMessage("No Internet Available");
                    }
                })
                .subscribe(new SingleSubscriber<JsonElement>() {
                    @Override
                    public void onSuccess(JsonElement jsonElement) {
                        view.stopLoading();
                        view.showMessage("Success");
                        Log.d(TAG, "onSuccess: " + jsonElement);
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.stopLoading();
                        error.printStackTrace();
                    }
                });
    }
}

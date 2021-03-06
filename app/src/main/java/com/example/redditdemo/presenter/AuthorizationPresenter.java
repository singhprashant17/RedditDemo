package com.example.redditdemo.presenter;

import android.util.Log;

import com.example.redditdemo.R;
import com.example.redditdemo.model.AuthorizationResponse;
import com.example.redditdemo.utility.Constants;
import com.example.redditdemo.utility.PreferencesManager;
import com.example.redditdemo.utility.Utility;
import com.example.redditdemo.viewinterface.AuthorizationView;
import com.example.redditdemo.webapi.NoInternetException;
import com.example.redditdemo.webapi.WebService;
import com.exmaple.androidmvp.MvpPresenter;

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
                .authorizeClient(Constants.AUTHORIZATION_CODE, code, REDIRECT_URI)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(() -> {
                    // chk if network available
                    if (!Utility.checkNetwork()) {
                        throw new NoInternetException();
                    }
                })
                .doOnSuccess(response -> PreferencesManager.saveObject(Constants.SharedPrefs.AUTHORIZATION, response))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> view.startLoading(view.getAndroidContext().getString(R.string.loading)))
                .doOnError(throwable -> {
                    if (throwable instanceof NoInternetException) {
                        view.showMessage(view.getAndroidContext().getString(R.string.no_internet));
                    }
                })
                .subscribe(new SingleSubscriber<AuthorizationResponse>() {
                    @Override
                    public void onSuccess(AuthorizationResponse response) {
                        Log.d(TAG, "onSuccess: " + response.toString());
                        view.stopLoading();
                        view.showMessage(view.getAndroidContext().getString(R.string.success));
                        view.onSuccess();
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

package com.example.redditdemo.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.redditdemo.R;
import com.example.redditdemo.presenter.AuthorizationPresenter;
import com.example.redditdemo.viewinterface.AuthorizationView;
import com.exmaple.androidmvp.MvpActivity;
import com.exmaple.androidmvp.PresenterFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.redditdemo.utility.Constants.Url.AUTH_URL;
import static com.example.redditdemo.utility.Constants.Url.CLIENT_ID;
import static com.example.redditdemo.utility.Constants.Url.REDIRECT_URI;
import static com.example.redditdemo.utility.Constants.Url.STATE;

public class AuthorizeActivity extends MvpActivity<AuthorizationPresenter, AuthorizationView> implements AuthorizationView {

    private static final String TAG = AuthorizeActivity.class.getSimpleName();
    @BindView(R.id.webView)
    WebView webView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        startSignIn();
    }

    @Override
    protected void onPresenterCreatedOrRestored(AuthorizationPresenter presenter) {

    }

    @Override
    public PresenterFactory<AuthorizationPresenter> getPresenterFactory() {
        return AuthorizationPresenter::new;
    }

    private void initViews() {
        progressDialog = new ProgressDialog(this);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                final Uri uri = Uri.parse(url);
                if (uri.getQueryParameter("error") != null) {
                    String error = uri.getQueryParameter("error");
                    Log.d(TAG, "shouldOverrideUrlLoading: error " + error);
                    showMessage(getString(R.string.error));
                } else {
                    String state = uri.getQueryParameter("state");
                    if (STATE.equals(state)) {
                        webView.setVisibility(View.INVISIBLE);
                        String code = uri.getQueryParameter("code");
                        getAccessToken(code);
                    } else {
                        startSignIn();
                    }
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private void getAccessToken(String code) {
        Log.d(TAG, "getAccessToken: " + code);
        getPresenter().authorizeClient(code);
    }

    public void startSignIn() {
        String url = String.format(AUTH_URL, CLIENT_ID, STATE, REDIRECT_URI);
        webView.loadUrl(url);
    }

    @Override
    public Context getAndroidContext() {
        return this;
    }

    @Override
    public void showMessage(String msg) {
        Snackbar.make(webView, msg, Snackbar.LENGTH_LONG).show();
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

    @Override
    public void onSuccess() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}

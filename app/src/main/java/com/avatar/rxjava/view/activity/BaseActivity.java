package com.avatar.rxjava.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.avatar.rxjava.presenter.BasePresenter;

/**
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-17
 * Time: 17:58
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected BasePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        if (presenter != null) {
            setContentView(this.presenter.getBaseView().getView());
        }
    }

    public abstract BasePresenter getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestory();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }
}

package com.avatar.rxjava.view.activity;

import android.os.Bundle;

import com.avatar.rxjava.R;
import com.avatar.rxjava.presenter.BasePresenter;
import com.avatar.rxjava.presenter.acitivty.UserPresenter;
import com.avatar.rxjava.view.UserView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class UserActivity extends BaseActivity {

    @Override
    public BasePresenter getPresenter() {
        return new UserPresenter(new UserView(this, R.layout.activity_main));
    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Logger.init("rxjava").hideThreadInfo();
//        query("hello").subscribe(urls -> {
//            for (String url : urls) {
//                Logger.e(url);
//            }
//        });
//
//        query("world").flatMap(urls -> Observable.from(urls))
//                .debounce(3, TimeUnit.SECONDS)
//                .subscribe(url -> {
//                    Logger.e(url);
//                });
//
//        query("moon").flatMap(urls -> Observable.from(urls))
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(url -> Logger.e(url));
//
//
//
//        query("jokin").flatMap(urls -> Observable.from(urls))
//                .flatMap(url -> getTitle(url))
//                .filter(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String r) {
//                        return r != null;
//                    }
//                })
//                .take(4)
//                .subscribe(url -> Logger.e(url));
//
//        Observable<String> test1 = Observable.just("test1");
//        Observable<String> test2 = Observable.just("test2");
//        Observable<String> test3 = Observable.just("test3");
//
//        Observable<String> test = Observable.concat(test1, test2, test3)
//        .first();
//
//        test.subscribe(str -> Logger.e(str));
//    }
//
//    Observable<List<String>> query(String text) {
//        List<String> urls = new ArrayList<>();
//        for (int i = 0; i < 10; i++){
//            urls.add("http://bsdf.com/" + text + "" + i);
//        }
//        return Observable.just(urls);
//    }
//
//    private Observable<String> getTitle(String url) {
//        return Observable.just(url)
//                .flatMap(mUrl -> Observable.just("title_" + mUrl));
//    }
}

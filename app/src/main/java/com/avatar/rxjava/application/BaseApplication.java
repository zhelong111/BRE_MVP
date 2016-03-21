package com.avatar.rxjava.application;/**
 * Author: Bruce
 * Email: zhelong0615@gmail.com
 * Date: 2016/3/11 11:28
 */

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 11:28
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("RxJava").setLogLevel(LogLevel.FULL);
    }
}

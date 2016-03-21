package com.avatar.rxjava.presenter.acitivty;

import com.avatar.rxjava.bean.UserBean;
import com.avatar.rxjava.model.UserModel;
import com.avatar.rxjava.presenter.BasePresenter;
import com.avatar.rxjava.service.timer.TimerManager;
import com.avatar.rxjava.view.UserView;
import com.avatar.rxjava.view.base.BaseView;
import com.orhanobut.logger.Logger;

/**
 * 关于User模块的业务逻辑，model与view的桥梁
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 18:49
 */
public class UserPresenter extends BasePresenter<UserView> {

    private UserModel userModel;

    public UserPresenter(UserView baseView) {
        super(baseView);
    }

    @Override
    public void init() {
        UserBean userBean = new UserBean();
        userBean.setFirstName("bruce");
        userBean.setLastName("Zhou");
        userBean.setTimeStamp("" + System.currentTimeMillis());
        userModel = new UserModel(userBean);
        baseView.showLastName(userModel.getLastName());

//        startRefresh();
        getBaseView().setViewState(BaseView.STATE.LOADING);
//        getBaseView().setViewState(BaseView.STATE.LOADED);
    }

    private String timerId;

    /**
     * 定时刷新
     */
    private void startRefresh() {
        timerId = TimerManager.getInstance().executePeriod(
                () -> Logger.e("timer", "test...")
                , 10, 1000);
    }

    @Override
    public void onDestory() {
        super.onDestory();
        Logger.e("timer", "cancel timer " + timerId);
        TimerManager.getInstance().cancel(timerId);
    }
}

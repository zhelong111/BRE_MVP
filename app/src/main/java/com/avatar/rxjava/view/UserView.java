package com.avatar.rxjava.view;

import android.content.Context;
import android.view.View;
import com.avatar.rxjava.R;
import com.avatar.rxjava.view.base.BaseView;
import com.avatar.rxjava.view.delegate.IUserView;

/**
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 16:47
 */
public class UserView extends BaseView<View> implements IUserView {

    public UserView(View view) {
        super(view);
    }

    public UserView(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void showUserName(String firstName, String lastName) {
        getTextView(R.id.tv_name).setText(firstName + " " + lastName);
    }

    @Override
    public String getUserName() {
        return getTextView(R.id.tv_name).getText().toString();
    }

    @Override
    public void showLastName(String lastName) {
        getTextView(R.id.tv_name).setText(lastName);
    }

    public void sayHello(){

    }
}

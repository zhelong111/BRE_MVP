package com.avatar.rxjava.view.delegate;

/**
 * Author: Bruce
 * Email: zhelong0615@gmail.com
 * Date: 2016/3/11 16:45
 */
public interface IUserView {
    /**
     *
     * @param firstName
     * @param lastName
     */
    void showUserName(String firstName, String lastName);
    String getUserName();
    void showLastName(String lastName);
}

package com.avatar.rxjava.model.delegate;/**
 * Author: Bruce
 * Email: zhelong0615@gmail.com
 * Date: 2016/3/11 16:33
 */

import com.avatar.rxjava.bean.UserBean;

/**
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 16:33
 */
public interface IUserModel {
    String getFirstName();
    String getLastName();
    UserBean getUser();
}

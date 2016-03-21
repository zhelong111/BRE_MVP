package com.avatar.rxjava.model;/**
 * Author: Bruce
 * Email: zhelong0615@gmail.com
 * Date: 2016/3/11 16:32
 */

import com.avatar.rxjava.bean.UserBean;
import com.avatar.rxjava.model.base.BaseModel;
import com.avatar.rxjava.model.delegate.IUserModel;

/**
 * 用户model提供数据
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 16:32
 */
public class UserModel extends BaseModel<UserBean> implements IUserModel {

    public UserModel(UserBean bean) {
        super(bean);
    }

    @Override
    public String getFirstName() {
        return bean.getFirstName();
    }

    @Override
    public String getLastName() {
        return bean.getLastName();
    }

    @Override
    public UserBean getUser() {
        return bean;
    }
}

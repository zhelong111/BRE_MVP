package com.avatar.rxjava.bean;/**
 * Author: Bruce
 * Email: zhelong0615@gmail.com
 * Date: 2016/3/11 16:31
 */

import com.avatar.rxjava.bean.base.BaseBean;

/**
 * 类似VO
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 16:31
 */
public class UserBean extends BaseBean {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

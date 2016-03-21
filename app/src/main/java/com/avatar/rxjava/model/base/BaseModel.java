package com.avatar.rxjava.model.base;/**
 * Author: Bruce
 * Email: zhelong0615@gmail.com
 * Date: 2016/3/11 16:35
 */

import com.avatar.rxjava.bean.base.BaseBean;

/**
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-11
 * Time: 16:35
 */
public class BaseModel<T extends BaseBean> {
    protected T bean;
    public BaseModel(T bean) {
        this.bean = bean;
    }
}

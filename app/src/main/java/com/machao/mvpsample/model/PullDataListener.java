package com.machao.mvpsample.model;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 17:11  <br>
 * Desc:    <br>
 */
/**
 * 请求回调接口
 */
public interface PullDataListener<T> {

    void onSuccess(T t);

    void onFailed(String msg);

}

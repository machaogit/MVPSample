package com.machao.mvpsample.net;

import android.widget.Toast;

import com.machao.mvpsample.model.GetDataManager;
import com.machao.mvpsample.model.PullDataListener;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 16:19  <br>
 * Desc:    <br>
 */
public class CustomSubscribe<T> extends Subscriber<T> {


    private PullDataListener listener;

    public CustomSubscribe(PullDataListener listener) {
        this.listener = listener;
    }


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException){
            listener.onFailed("网络中断，请检查您的网络状态");
        } else if(e instanceof ConnectException) {
            listener.onFailed("网络中断，请检查您的网络状态");
        }  else {
            listener.onFailed("服务端出错");
        }
    }

    @Override
    public void onNext(T t) {
        listener.onSuccess(t);
    }
}

package com.machao.mvpsample.net.adapter;

import com.machao.mvpsample.net.OkHttpCall;

import rx.Observable;
import rx.Subscriber;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 14:44  <br>
 * Desc:    <br>
 */
public class RxCallAdapter<T> implements CallAdapter<Observable<T>> {

    @Override
    public Observable<T> adapter(final OkHttpCall call) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext((T) call.request());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}

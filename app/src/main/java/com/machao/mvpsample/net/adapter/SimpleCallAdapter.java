package com.machao.mvpsample.net.adapter;

import com.machao.mvpsample.net.OkHttpCall;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 14:46  <br>
 * Desc:    <br>
 */
public class SimpleCallAdapter<T> implements CallAdapter<T> {
    @Override
    public T adapter(OkHttpCall call) {
        return (T) call.request();
    }
}

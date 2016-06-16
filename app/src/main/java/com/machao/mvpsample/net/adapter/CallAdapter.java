package com.machao.mvpsample.net.adapter;

import com.machao.mvpsample.net.OkHttpCall;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 11:49  <br>
 * Desc:    <br>
 */
public interface CallAdapter<T> {
    T adapter(OkHttpCall call);
}

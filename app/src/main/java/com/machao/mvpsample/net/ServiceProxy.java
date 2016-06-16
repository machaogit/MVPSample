package com.machao.mvpsample.net;

import com.machao.mvpsample.net.adapter.CallAdapter;
import com.machao.mvpsample.net.converter.Converter;
import com.machao.mvpsample.net.http.ServiceMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 14:28  <br>
 * Desc:    <br>
 */
public class ServiceProxy implements InvocationHandler {
    CustomRetrofit retrofit;

    public ServiceProxy(CustomRetrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }

        ServiceMethod serviceMethod = new ServiceMethod(method);
        Converter converter = retrofit.converter(serviceMethod.actualType);
        CallAdapter adapter = retrofit.callAdapter();

        OkHttpCall call = new OkHttpCall(converter,serviceMethod,args);

        return adapter.adapter(call);
    }
}

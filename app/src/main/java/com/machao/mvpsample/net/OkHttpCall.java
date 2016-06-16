package com.machao.mvpsample.net;

import com.machao.mvpsample.net.converter.Converter;
import com.machao.mvpsample.net.http.ServiceMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 11:51  <br>
 * Desc:    <br>
 */
public class OkHttpCall<T> {
    private HttpClientHelper client;
    private Converter converter;
    private ServiceMethod serviceMethod;
    private Object[] args;

    public OkHttpCall(Converter converter, ServiceMethod serviceMethod, Object[] args) {
        this.client = new HttpClientHelper("api.github.com");

        this.converter = converter;
        this.serviceMethod = serviceMethod;
        this.args = args;
    }

    public T request() {

        try {
            //检测参数个数是否一致
            int argumentCount = (args != null ? args.length : 0);
            if (argumentCount != serviceMethod.argumentTypes.length) {
                throw new IllegalArgumentException("Argument count (" + argumentCount + ") doesn't match expected count (" + serviceMethod.argumentTypes.length + ")");
            }

            Map<String, Object> params = new HashMap<>();

            for (int i = 0; i < argumentCount; i++) {
                params.put(serviceMethod.getQueryKey(i), args[i].toString());
            }

            String url = serviceMethod.url();
            String json = client.get(url, params);

            return (T) converter.convert(json);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}

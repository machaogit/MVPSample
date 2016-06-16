package com.machao.mvpsample.net;

import com.machao.mvpsample.net.adapter.CallAdapter;
import com.machao.mvpsample.net.adapter.SimpleCallAdapter;
import com.machao.mvpsample.net.converter.Converter;
import com.machao.mvpsample.net.converter.ConverterFactory;
import com.machao.mvpsample.net.converter.GsonConverterFactory;

import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 11:28  <br>
 * Desc:    <br>
 */
public class CustomRetrofit {
    CallAdapter adapter;
    ConverterFactory converterFactory;

    public CustomRetrofit(CallAdapter adapter, ConverterFactory converterFactory) {
        this.adapter = adapter;
        this.converterFactory = converterFactory;
    }

    public <T> T create(Class<T> tClass) {
        if (!tClass.isInterface()) {
            throw new RuntimeException("Service not interface");
        }

        return (T) Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass},new ServiceProxy(this));
    }

    public Converter converter(Type returnType) {
        return converterFactory.getConverter(returnType);
    }

    public CallAdapter callAdapter() {
        return adapter;
    }

    public static class Builder{
        CallAdapter      adapter;
        ConverterFactory converterFactory;

        public Builder callAdapter(CallAdapter callAdapter){
            this.adapter = callAdapter;
            return this;
        }

        public Builder converter(ConverterFactory converterFactory){
            this.converterFactory = converterFactory;
            return this;
        }

        public CustomRetrofit build() {
            if (adapter == null){
                adapter = new SimpleCallAdapter();
            }

            if (converterFactory == null){
                converterFactory = new GsonConverterFactory();
            }

            return new CustomRetrofit(adapter,converterFactory);
        }
    }
}

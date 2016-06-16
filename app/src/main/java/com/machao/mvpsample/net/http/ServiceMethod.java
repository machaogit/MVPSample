package com.machao.mvpsample.net.http;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 11:42  <br>
 * Desc:    <br>
 */
public class ServiceMethod {
    public Method method;
    public Annotation[] methodAnnotations;
    public Annotation[][] argumentAnnotations;
    public Class[] argumentTypes;

    public Type returnType;
    public Type actualType;

    public ServiceMethod(Method method) {
        this.method = method;

        methodAnnotations = method.getDeclaredAnnotations();
        argumentAnnotations = method.getParameterAnnotations();
        argumentTypes = method.getParameterTypes();
        returnType = method.getGenericReturnType();

        if (returnType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            actualType = parameterizedType.getActualTypeArguments()[0];
        } else {
            actualType = returnType;
        }
    }

    public String getQueryKey(int index) {
        for (Annotation annotation : argumentAnnotations[index]){
            if (annotation instanceof Query){
                return ((Query) annotation).value();
            }
        }

        return "";
    }

    public String url() {
        for (Annotation annotation : methodAnnotations) {
            if (annotation instanceof Get){
                String url = ((Get) annotation).value();
                return url;
            }
        }

        throw new RuntimeException("no GET annotation");
    }
}

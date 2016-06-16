package com.machao.mvpsample.net.converter;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 12:18  <br>
 * Desc:    <br>
 */
public class GsonConverterFactory implements ConverterFactory {

    Gson gson;

    public GsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    public GsonConverterFactory() {
        gson = new Gson();
    }

    @Override
    public Converter getConverter(Type type) {
        return new GsonConverter<>(gson,type);
    }
}

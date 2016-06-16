package com.machao.mvpsample.net.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 12:16  <br>
 * Desc:    <br>
 */
public class GsonConverter<T> implements Converter {
    TypeAdapter adapter;

    public GsonConverter(Gson gson, Type type) {
        adapter = gson.getAdapter(TypeToken.get(type));
    }

    @Override
    public Object convert(String json) throws IOException {

        JSONArray array = null;
        String objectString = null;
        try {
            array = new JSONArray(json);
            objectString = array.get(0).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (T) adapter.fromJson(objectString);
    }
}

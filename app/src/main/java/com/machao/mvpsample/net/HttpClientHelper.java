package com.machao.mvpsample.net;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 12:20  <br>
 * Desc:   请求实现类 <br>
 */
public class HttpClientHelper {

    private String host;

    private static final int DEFAULT_TIMEOUT = 20;

    public HttpClientHelper(String host) {
        this.host = host;
    }

    public String get(String url, Map<String, Object> params) {

        String res = null;
        try {
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder urlBuilder = new HttpUrl.Builder().scheme("https")
                    .host(host)
                    .addEncodedPathSegments(url);

            for (String key : params.keySet()) {
                urlBuilder.addQueryParameter(key,params.get(key).toString());
            }

            HttpUrl httpUrl = urlBuilder.build();
            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();
            Response response = client.newCall(request).execute();
            res =response.body().string();
            Log.e("httpclienthelper",res);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}

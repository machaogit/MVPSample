package com.machao.mvpsample.model;

import com.machao.mvpsample.net.CustomRetrofit;
import com.machao.mvpsample.net.CustomSubscribe;
import com.machao.mvpsample.net.adapter.RxCallAdapter;
import com.machao.mvpsample.net.api.GitHubApi;
import com.machao.mvpsample.net.converter.GsonConverterFactory;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 11:15  <br>
 * Desc:   获取github user api 数据管理类 <br>
 */
public class GetDataManager {

    private static final GetDataManager instance = new GetDataManager();
    private GitHubApi gitHubApi;

    public GetDataManager() {
        gitHubApi = new CustomRetrofit.Builder().callAdapter(new RxCallAdapter())
                .converter(new GsonConverterFactory())
                .build()
                .create(GitHubApi.class);
    }

    public static GetDataManager getInstance() {
        return instance;
    }



    public void getRepos(String values, final PullDataListener listener) {

        gitHubApi.getData(values)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomSubscribe<Repos>(listener));
    }

}

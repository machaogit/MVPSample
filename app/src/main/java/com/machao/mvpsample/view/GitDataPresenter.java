package com.machao.mvpsample.view;

import android.util.Log;

import com.machao.mvpsample.base.GetDataContract;
import com.machao.mvpsample.model.GetDataManager;
import com.machao.mvpsample.model.PullDataListener;
import com.machao.mvpsample.model.Repos;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 16:51  <br>
 * Desc:    <br>
 */
public class GitDataPresenter implements GetDataContract.IGitDataPresenter {

    private GetDataContract.IGitDataView gitDataView;
    private GetDataManager manager = GetDataManager.getInstance();

    @Override
    public void fetchData(String values) {
        gitDataView.ShowLoadingView();
        manager.getRepos(values, new PullDataListener<Repos>() {
            @Override
            public void onSuccess(Repos repos) {
                Log.e("res",repos.getName());
                gitDataView.onShowSuccessView(repos);
                gitDataView.dissLoadingView();
            }

            @Override
            public void onFailed(String msg) {
                gitDataView.onShowFailedView(msg);
                gitDataView.dissLoadingView();
            }
        });
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void init(GetDataContract.IGitDataView view) {
        gitDataView = view;
        gitDataView.initView();
    }
}

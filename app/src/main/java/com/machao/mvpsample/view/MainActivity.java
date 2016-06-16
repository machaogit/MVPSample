package com.machao.mvpsample.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.machao.mvpsample.R;
import com.machao.mvpsample.base.BaseActivity;
import com.machao.mvpsample.base.BasePresenter;
import com.machao.mvpsample.base.GetDataContract;
import com.machao.mvpsample.model.Repos;

import java.util.List;
/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 16:51  <br>
 * Desc:    <br>
 */
public class MainActivity extends BaseActivity implements GetDataContract.IGitDataView{

    private GitDataPresenter presenter = new GitDataPresenter();

    TextView tvData;
    Button btn;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter[] getPresenter() {
        return new BasePresenter[]{presenter};
    }

    @Override
    protected void inItPresenters() {
        presenter.init(this);
    }

    @Override
    public void onShowSuccessView(Repos repos) {
        showToastSafe(repos.getName());
        tvData.setText(repos.getOwner().getAvatar_url());
    }

    @Override
    public void onShowFailedView(String msg) {
        showToastSafe(msg);
    }

    @Override
    public void ShowLoadingView() {
        showLoading("正在连接...");
    }

    @Override
    public void dissLoadingView() {
        hideLoading();
    }

    @Override
    public void initView() {

        tvData = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchData("owner");
            }
        });
    }
}

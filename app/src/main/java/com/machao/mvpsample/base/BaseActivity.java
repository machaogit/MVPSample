package com.machao.mvpsample.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 17:19  <br>
 * Desc:   activity基类 <br>
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Set<BasePresenter> mAllPresenters = new HashSet<BasePresenter>();
    private int tid;
    private Handler handler;
    private LayoutInflater inflater;
    private ProgressDialog loadingViewDialog;
    private long lastToastTime;
    private String lastToastText;
    private static final long TOAST_INTERNAL = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        tid = Process.myTid();
        handler = new Handler();
        addPresenters();
        inItPresenters();
    }

    protected abstract int getLayoutResID();

    protected abstract BasePresenter[] getPresenter();

    protected abstract void inItPresenters();

    private void addPresenters(){

        BasePresenter[] presenters = getPresenter();
        if(presenters != null){
            for(int i = 0; i < presenters.length; i++){
                mAllPresenters.add(presenters[i]);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //依次调用IPresenter的onResume方法
        for (BasePresenter presenter:mAllPresenters  ) {
            if(presenter != null){
                presenter.onResume();
            }
        }
    }

    public void post(Runnable r) {
        handler.post(r);
    }

    public void showToastSafe(final String text) {
        if (text == null)
            return;
        if ((System.currentTimeMillis() - lastToastTime) < TOAST_INTERNAL && text.equals(lastToastText))
            return;
        if (tid == Process.myTid()) {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(BaseActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            });
        }
        lastToastTime = System.currentTimeMillis();
        lastToastText = text;
    }

    public void showToastSafe(int id) {
        showToastSafe(getString(id));
    }

    public void showLoading(final String tip) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isValidContext(BaseActivity.this)) {
                    if (loadingViewDialog == null) {
                        loadingViewDialog = new ProgressDialog(BaseActivity.this);
                        loadingViewDialog.setCanceledOnTouchOutside(false);
                    }
                    loadingViewDialog.setMessage(tip);
                    loadingViewDialog.show();
                }
            }
        });

    }

    public void hideLoading() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isValidContext(BaseActivity.this)) {
                    if (loadingViewDialog != null && loadingViewDialog.isShowing()) {
                        loadingViewDialog.hide();
                    }
                }
            }
        });
    }

    protected boolean isValidContext(Activity a) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (a.isDestroyed() || a.isFinishing()) {
                return false;
            } else {
                return true;
            }
        } else {
            if (a.isFinishing()) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loadingViewDialog != null) {
            loadingViewDialog.dismiss();
            loadingViewDialog = null;
        }
    }

}

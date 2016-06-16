package com.machao.mvpsample.base;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 16:30  <br>
 * Desc:   所有Presenter的基类  对应Activity或Fragment的生命周期方法<br>
 */
public interface BasePresenter <V extends BaseView> {

    void onStop();

    void onResume();

    void onDestroy();

    void onPause();

    void onStart();

    void init(V view);
}


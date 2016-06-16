package com.machao.mvpsample.base;

import com.machao.mvpsample.model.Repos;

import java.util.List;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 16:33  <br>
 * Desc:   条约接口，分别定义了view 和presenter的方法  <br>
 */
public interface GetDataContract {

    interface IGitDataView extends BaseView{

        void onShowSuccessView(Repos repos);

        void onShowFailedView(String msg);

        void ShowLoadingView();

        void dissLoadingView();

    }

    interface IGitDataPresenter extends BasePresenter<IGitDataView>{

        void fetchData(String values);

    }

}

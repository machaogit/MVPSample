package com.machao.mvpsample.net.api;

import com.machao.mvpsample.model.Repos;
import com.machao.mvpsample.net.http.Get;
import com.machao.mvpsample.net.http.Query;

import rx.Observable;


/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 14:47  <br>
 * Desc:    <br>
 */
public interface GitHubApi {

    @Get("users/machaogit/repos")
    Observable<Repos> getData(@Query("type") String values);
}

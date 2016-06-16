package com.machao.mvpsample.net.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 11:31  <br>
 * Desc:   get请求 <br>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Get {
    String value() default "";
}


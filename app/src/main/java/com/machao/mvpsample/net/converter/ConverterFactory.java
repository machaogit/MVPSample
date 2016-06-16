package com.machao.mvpsample.net.converter;

import java.lang.reflect.Type;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 12:01  <br>
 * Desc:    <br>
 */
public interface ConverterFactory {
    Converter getConverter(Type type);
}

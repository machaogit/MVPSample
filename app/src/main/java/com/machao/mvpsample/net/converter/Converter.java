package com.machao.mvpsample.net.converter;

import java.io.IOException;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 11:59  <br>
 * Desc:    <br>
 */
public interface Converter<T> {

    T convert(String json) throws IOException;

}

package com.whoiszxl.ab;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zxlvoid on 2017/12/21 0021.
 */

@Target(ElementType.TYPE)//指定处理类
@Retention(RetentionPolicy.SOURCE)//源码阶段处理,打包apk就不在使用了
public @interface EntryGenerator {

    String packageName();

    Class<?> entryTemplate();
}

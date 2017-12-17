package com.whoiszxl.ab.app;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 * 单例,只能被初始化一次的enum枚举
 */
public enum ConfigType {

    /**
     * 网络请求时候,配置一些域名
     */
    API_HOST,

    /**
     * android全局上下文
     */
    APPLICATION_CONTEXT,

    /**
     * 配置初始化是否完成了没
     */
    CONFIG_READY,

    /**
     * 存储一些自己的初始化项目
     */
    ICON
}

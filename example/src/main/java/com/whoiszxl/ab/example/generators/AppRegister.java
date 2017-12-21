package com.whoiszxl.ab.example.generators;

import com.whoiszxl.ab.AppRegisterGenerator;
import com.whoiszxl.ab.wechat.templates.AppRegisterTemplate;

/**
 * Created by zxlvoid on 2017/12/21 0021.
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.whoiszxl.ab.example",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}

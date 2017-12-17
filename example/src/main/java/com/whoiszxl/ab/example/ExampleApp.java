package com.whoiszxl.ab.example;

import android.app.Application;

import com.whoiszxl.ab.app.Ab;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Ab.init(this).configure();

    }
}

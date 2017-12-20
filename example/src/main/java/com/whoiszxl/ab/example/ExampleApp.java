package com.whoiszxl.ab.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.whoiszxl.ab.app.Ab;
import com.whoiszxl.ab.ec.database.DataBaseManager;
import com.whoiszxl.ab.net.interceptors.DebugInterceptor;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Ab.init(this)
                .withLoaderDelayed(1000)
                .withApiHost("http://127.0.0.1")
                .withInterceptor(new DebugInterceptor("index",R.raw.test))
                .configure();
        initStetho();
        DataBaseManager.getInstance().init(this);
    }

    private void initStetho(){
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }
}

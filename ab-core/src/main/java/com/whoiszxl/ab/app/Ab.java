package com.whoiszxl.ab.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 */

public final class Ab {

    public static Configurator init(Context context) {
        getConfiguration().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfiguration() {
        return Configurator.getInstance().getAbConfigs();
    }

}

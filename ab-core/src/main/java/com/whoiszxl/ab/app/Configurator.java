package com.whoiszxl.ab.app;

import java.util.WeakHashMap;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 * 初始化时候的单例,一般用懒汉模式,懒汉模式中用双重校验锁,这效率不高,或者用天生单例的枚举进行初始化,
 * 再或者用静态内部类,当前就使用这个
 */
public class Configurator {

    /**
     * weakHashMap在键值对未使用的时候就会进行回收,很及时,极大限度避免内存爆满
     */
    private static final WeakHashMap<String, Object> AB_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        AB_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public final WeakHashMap getAbConfigs() {
        return AB_CONFIGS;
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 静态内部类进行懒加载当前类的实例
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        AB_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        AB_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) AB_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("config not ready....");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) AB_CONFIGS.get(key.name());
    }
}

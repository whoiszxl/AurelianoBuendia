package com.whoiszxl.ab.app;

import android.app.Activity;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

import okhttp3.Interceptor;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 * 初始化时候的单例,一般用懒汉模式,懒汉模式中用双重校验锁,这效率不高,或者用天生单例的枚举进行初始化,
 * 再或者用静态内部类,当前就使用这个
 */
public class Configurator {

    /**
     * weakHashMap在键值对未使用的时候就会进行回收,很及时,极大限度避免内存爆满
     */
    private static final HashMap<Object, Object> AB_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator() {
        AB_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public final HashMap<Object, Object> getAbConfigs() {
        return AB_CONFIGS;
    }

    /**
     * 静态内部类进行懒加载当前类的实例
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        initIcons();
        AB_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    public final Configurator withApiHost(String host) {
        AB_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    public final Configurator withLoaderDelayed(long delayed) {
        AB_CONFIGS.put(ConfigKeys.LOADER_DELAYED, delayed);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        AB_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        AB_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withWeChatAppId(String appId) {
        AB_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID,appId);
        return this;
    }

    public final Configurator withWeChatAppSecret(String appSecret) {
        AB_CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET,appSecret);
        return this;
    }

    public final Configurator withActivity(Activity activity) {
        AB_CONFIGS.put(ConfigKeys.ACTIVITY,activity);
        return this;
    }


    private void checkConfiguration() {
        final boolean isReady = (boolean) AB_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("config not ready....");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();//检查是否加载完毕
        final Object value = AB_CONFIGS.get(key);//通过key获取到配置中的object对象
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        //直接返回get到的value
        return (T) AB_CONFIGS.get(key);
    }
}

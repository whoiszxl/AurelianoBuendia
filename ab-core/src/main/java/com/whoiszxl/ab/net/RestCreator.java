package com.whoiszxl.ab.net;

import com.whoiszxl.ab.app.Ab;
import com.whoiszxl.ab.app.ConfigType;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 */

public class RestCreator {

    public static RestService getRestService(){
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {
        //通过之前配置好的单例配置config类获取到api的host域名
        private static final String BASE_URL = (String) Ab.getConfiguration().get(ConfigType.API_HOST.name());
        //通过retrofit构建一个client类
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    /**
     * build一个okhttp客户端
     */
    private static final class OKHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 最后要返回的一个存有实际接口的service
     */
    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

}

package com.whoiszxl.ab.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.whoiszxl.ab.app.Ab;
import com.whoiszxl.ab.app.ConfigKeys;

/**
 * Created by zxlvoid on 2017/12/22 0022.
 */

public class AbWechat {

    public static final String APP_ID = Ab.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    public static final String APP_SECRET = Ab.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;

    private static final class Holder{
        private static final AbWechat INSTANCE = new AbWechat();
    }

    public static AbWechat getInstance(){
        return Holder.INSTANCE;
    }

    private AbWechat(){
        final Activity activity = Ab.getConfiguration(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity,APP_ID,true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}

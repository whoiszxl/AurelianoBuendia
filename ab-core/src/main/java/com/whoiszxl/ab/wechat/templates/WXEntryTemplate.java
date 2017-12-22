package com.whoiszxl.ab.wechat.templates;

import com.whoiszxl.ab.activities.ProxyActivity;
import com.whoiszxl.ab.delegates.AbDelegate;
import com.whoiszxl.ab.wechat.BaseWXEntryActivity;

/**
 * Created by zxlvoid on 2017/12/21 0021.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {

    }
}

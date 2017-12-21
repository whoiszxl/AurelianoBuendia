package com.whoiszxl.ab.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * Created by zxlvoid on 2017/12/22 0022.
 */

public abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这个必须写在onCreate中
        AbWechat.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        AbWechat.getInstance().getWXAPI().handleIntent(getIntent(), this);
    }
}

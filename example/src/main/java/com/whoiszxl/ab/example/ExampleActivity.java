package com.whoiszxl.ab.example;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.whoiszxl.ab.activities.ProxyActivity;
import com.whoiszxl.ab.delegates.AbDelegate;
import com.whoiszxl.ab.ec.launcher.LauncherDelegate;
import com.whoiszxl.ab.ec.launcher.LauncherScrollDelegate;
import com.whoiszxl.ab.ec.sign.SignInDelegate;
import com.whoiszxl.ab.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public AbDelegate setRootDelegate() {
        return new SignUpDelegate();
    }
}
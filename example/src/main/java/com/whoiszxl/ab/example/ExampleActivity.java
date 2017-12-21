package com.whoiszxl.ab.example;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.whoiszxl.ab.activities.ProxyActivity;
import com.whoiszxl.ab.app.Ab;
import com.whoiszxl.ab.delegates.AbDelegate;
import com.whoiszxl.ab.ec.launcher.LauncherDelegate;
import com.whoiszxl.ab.ec.launcher.LauncherScrollDelegate;
import com.whoiszxl.ab.ec.sign.ISignListener;
import com.whoiszxl.ab.ec.sign.SignInDelegate;
import com.whoiszxl.ab.ec.sign.SignUpDelegate;
import com.whoiszxl.ab.ui.launcher.ILauncherListener;
import com.whoiszxl.ab.ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements
        ISignListener,
        ILauncherListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        Ab.getConfigurator().withActivity(this);
    }

    @Override
    public AbDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功了", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功了", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag){
            case SIGNED:
                Toast.makeText(this,"用户已经登录了",Toast.LENGTH_LONG).show();
                startWithPop(new SignInDelegate());
                start(new ExampleDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this,"用户未登录",Toast.LENGTH_SHORT).show();
                start(new SignInDelegate());
                //startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
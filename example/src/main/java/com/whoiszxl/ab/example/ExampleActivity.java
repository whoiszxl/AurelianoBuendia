package com.whoiszxl.ab.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.whoiszxl.ab.activities.ProxyActivity;
import com.whoiszxl.ab.delegates.AbDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public AbDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
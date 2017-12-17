package com.whoiszxl.ab.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.whoiszxl.ab.delegates.AbDelegate;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 */

public class ExampleDelegate extends AbDelegate {


    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}

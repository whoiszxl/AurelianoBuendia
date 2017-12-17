package com.whoiszxl.ab.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.whoiszxl.ab.delegates.AbDelegate;
import com.whoiszxl.ab.net.RestClient;
import com.whoiszxl.ab.net.callback.IError;
import com.whoiszxl.ab.net.callback.IFailure;
import com.whoiszxl.ab.net.callback.ISuccess;

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

    public void testRestClient(){
        RestClient.builder()
                .url("")
                .params("","")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build();
    }
}

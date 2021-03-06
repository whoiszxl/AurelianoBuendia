package com.whoiszxl.ab.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.whoiszxl.ab.delegates.AbDelegate;
import com.whoiszxl.ab.net.RestClient;
import com.whoiszxl.ab.net.callback.IError;
import com.whoiszxl.ab.net.callback.IFailure;
import com.whoiszxl.ab.net.callback.ISuccess;
import com.whoiszxl.ab.ui.loader.LoaderStyle;

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
        //testRestClient();
    }

    public void testRestClient(){
        RestClient.builder()
                .url("http://android.whoiszxl.com/RestServer/api/user_profile.php")
                .loader(getContext(), LoaderStyle.BallZigZagIndicator)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
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
                .build()
                .get();
    }
}

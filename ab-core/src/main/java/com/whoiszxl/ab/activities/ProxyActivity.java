package com.whoiszxl.ab.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.whoiszxl.ab.R;
import com.whoiszxl.ab.delegates.AbDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by zxlvoid on 2017/12/17 0017.
 */

public abstract class ProxyActivity extends SupportActivity {


    public abstract AbDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if(savedInstanceState==null){
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        System.gc();
        System.runFinalization();
    }
}

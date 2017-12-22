package com.whoiszxl.ab.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.whoiszxl.ab.delegates.bottom.BottomItemDelegate;
import com.whoiszxl.ab.ec.R;

/**
 * Created by zxlvoid on 2017/12/22 0022.
 */

public class IndexDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}

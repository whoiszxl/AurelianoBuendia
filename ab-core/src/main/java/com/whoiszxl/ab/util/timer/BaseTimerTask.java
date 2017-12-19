package com.whoiszxl.ab.util.timer;

import java.util.TimerTask;

/**
 * Created by whoiszxl on 2017/12/19.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener mITimerListener) {
        this.mITimerListener = mITimerListener;
    }

    @Override
    public void run() {
        if(mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}

package com.whoiszxl.ab.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;
import com.whoiszxl.ab.R;
import com.whoiszxl.ab.util.DimenUtil;

import java.util.ArrayList;

/**
 * Created by whoiszxl on 2017/12/18.
 */

public class AbLoader {

    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();

    private static final String DEFAULT_LOADER = LoaderStyle.BallSpinFadeLoaderIndicator.name();

    public static void showLoading(Context context,Enum<LoaderStyle> type){
        showLoading(context,type.name());
    }

    public static void showLoading(Context context,String type){

        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceWidth = DimenUtil.getScreenWitdh();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();

        if(dialogWindow != null){
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }

        LOADERS.add(dialog);

        dialog.show();


    }

    /**
     * 展示loading图标
     * @param context
     */
    public static void showLoading(Context context){
        showLoading(context,DEFAULT_LOADER);
    }


    public static void stopLoading(){
        for(AppCompatDialog dialog : LOADERS){
            if(dialog != null){
                if(dialog.isShowing()){
                    dialog.cancel();
                    dialog.dismiss();
                }
            }
        }
    }



}

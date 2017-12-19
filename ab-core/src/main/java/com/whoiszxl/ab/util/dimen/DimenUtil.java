package com.whoiszxl.ab.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.whoiszxl.ab.app.Ab;

/**
 * Created by whoiszxl on 2017/12/18.
 */

public class DimenUtil {

    public static int getScreenWitdh(){
        final Resources resources = Ab.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Ab.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}

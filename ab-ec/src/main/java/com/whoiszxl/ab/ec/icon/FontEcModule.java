package com.whoiszxl.ab.ec.icon;
import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;
/**
 * Created by zxlvoid on 2017/12/18 0018.
 */

public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}

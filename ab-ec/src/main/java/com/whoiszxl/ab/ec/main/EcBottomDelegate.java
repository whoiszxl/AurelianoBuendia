package com.whoiszxl.ab.ec.main;

import android.graphics.Color;

import com.whoiszxl.ab.delegates.bottom.BaseBottomDelegate;
import com.whoiszxl.ab.delegates.bottom.BottomItemDelegate;
import com.whoiszxl.ab.delegates.bottom.BottomTabBean;
import com.whoiszxl.ab.delegates.bottom.ItemBuilder;
import com.whoiszxl.ab.ec.main.index.IndexDelegate;
import com.whoiszxl.ab.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by zxlvoid on 2017/12/22 0022.
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean,BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"), new IndexDelegate());

        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}

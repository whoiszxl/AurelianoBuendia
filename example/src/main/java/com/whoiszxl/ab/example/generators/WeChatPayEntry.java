package com.whoiszxl.ab.example.generators;

import com.whoiszxl.ab.PayEntryGenerator;
import com.whoiszxl.ab.wechat.templates.WXPayEntryTemplate;

/**
 * Created by zxlvoid on 2017/12/21 0021.
 */
@PayEntryGenerator(
        packageName = "com.diabin.fastec.example",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}

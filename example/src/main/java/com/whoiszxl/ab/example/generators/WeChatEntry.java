package com.whoiszxl.ab.example.generators;

import com.whoiszxl.ab.EntryGenerator;
import com.whoiszxl.ab.wechat.templates.WXEntryTemplate;

/**
 * Created by zxlvoid on 2017/12/21 0021.
 */
@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.whoiszxl.ab.example",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}

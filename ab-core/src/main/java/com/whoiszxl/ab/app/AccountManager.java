package com.whoiszxl.ab.app;

import com.whoiszxl.ab.util.storage.AbPreference;

/**
 * Created by zxlvoid on 2017/12/20 0020.
 */

public class AccountManager {

    private enum SignTag{
        SIGN_TAG
    }

    /**
     * 设置用户的登录状态
     * @param state
     */
    public static void setSignState(boolean state){
        AbPreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    /**
     * 判断用户是否登录了
     * @return
     */
    private static boolean isSignIn(){
        return AbPreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if(isSignIn()){
            checker.onSignIn();
        }else{
            checker.onNotSignIn();
        }
    }

}

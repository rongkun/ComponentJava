package com.kun.baselib.base;

/**
 * @author kun
 * @date 2017/11/14
 */

public class BasePresenter<V extends BaseActivityView>{
    protected V mView;
    public void attachView(V mView){
        this.mView = mView;
    }
    public void destroyView(){
        mView = null;
    }
}

package com.lotterytechnology.lottery.base;

/**
* @author Ryder
* create at 2018/4/6 10:55
* description: View 的基类
**/
public interface BaseView {
    /**
     * 没有网络、接口提示失败等需要提示用户时调用
     */
    void fail(String msg);

    /**
     * 没有数据时显示
     */
    void noData();

    /**
     * 显示加载进度条
     */
    void showProgress();

    /**
     * 隐藏加载进度条
     */
    void hideProgress();
}

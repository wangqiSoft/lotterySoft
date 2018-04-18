package com.lotterytechnology.lottery.ui;

import android.view.View;

import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseActivity;
import com.lotterytechnology.lottery.config.PreferencesConfig;
import com.lotterytechnology.lottery.utils.PreferencesUtils;

/**
 * @author Ryder
 * create at 2018/4/6 14:35
 * package name:com.lotterytechnology.runshop.ui
 * description: 这个是引导页界面
 **/
public class GuideActivity extends BaseActivity {


    @Override
    protected int getlayoutContentView() {
        return R.layout.activity_guide;
    }

    @Override
    protected View setTopView() {
        return super.setTopView();
    }

    @Override
    protected void initView() {
        super.initView();
        //设置引导页完成
        PreferencesUtils.putBoolean(this, PreferencesConfig.GuiActivityShow,true);
    }
}

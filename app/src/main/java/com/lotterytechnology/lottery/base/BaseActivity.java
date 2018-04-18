package com.lotterytechnology.lottery.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyco.systembar.SystemBarHelper;
import com.lotterytechnology.lottery.utils.ActivityManager;

import butterknife.ButterKnife;

/**
 * @author Ryder
 * create at 2018/4/6 10:39
 * description:  activity 的基类
 **/
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getlayoutContentView() > 0) {
            setContentView(getlayoutContentView());
            ButterKnife.bind(this);
        }
        initView();
        SystemBarHelper.immersiveStatusBar(this);
        if (setTopView() != null) {
            SystemBarHelper.setHeightAndPadding(this, setTopView());
        }
        ActivityManager.getInstance().addActivity(this);
    }


    protected View setTopView() {
        return null;
    }

    protected int getlayoutContentView() {
        return 0;
    }

    protected void initView() {

    }
}

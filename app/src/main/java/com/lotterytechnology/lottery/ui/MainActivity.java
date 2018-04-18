package com.lotterytechnology.lottery.ui;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseActivity;
import com.lotterytechnology.lottery.widget.MainPagerAdapter;
import com.lotterytechnology.lottery.widget.MyViewPager;

import butterknife.BindView;


/**
 * @author Ryder
 * create at 2018/4/9 23:16
 * package name:com.lotterytechnology.runshop.ui
 * description: 主界面
 **/
public class MainActivity extends BaseActivity {
    private MainPagerAdapter mainAdapter;

    @BindView(R.id.main_viewPager)
    MyViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @Override
    protected int getlayoutContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected View setTopView() {
        return super.setTopView();
    }

    @Override
    protected void initView() {
        super.initView();
        mainAdapter = new MainPagerAdapter(this, getSupportFragmentManager());
        mainAdapter.init();
        viewPager.setScrollble(false);
        viewPager.setAdapter(mainAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mainAdapter.getTabView(i));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

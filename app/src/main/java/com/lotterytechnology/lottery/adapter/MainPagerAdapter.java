package com.lotterytechnology.lottery.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.ui.fragment.AIDataFragment;
import com.lotterytechnology.lottery.ui.fragment.HomeFragment;
import com.lotterytechnology.lottery.ui.fragment.MeFragment;
import com.lotterytechnology.lottery.ui.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxy on 2016/3/28.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    private Context mContex;
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContex = context;
    }

    public void init() {
        this.addFragment(new HomeFragment(), "首页");
        this.addFragment(new AIDataFragment(), "AI大数据");
        this.addFragment(new NewsFragment(), "资讯");
        this.addFragment(new MeFragment(), "我的");
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContex).inflate(R.layout.tab_item, null);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(getPageTitle(position));
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(imageResId[position]);
        if (position == 0) {
            view.setSelected(true);
        }
        return view;
    }

    private int[] imageResId = {
            R.drawable.tab_home,
            R.drawable.tab_ai_data,
            R.drawable.tab_news,
            R.drawable.tab_me
    };

}

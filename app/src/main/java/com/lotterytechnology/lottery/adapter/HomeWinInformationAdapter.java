package com.lotterytechnology.lottery.adapter;


import android.graphics.Color;
import android.text.Html;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.bean.WinInfoBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Mars on 2016/1/24
 */

public class HomeWinInformationAdapter extends BaseQuickAdapter<WinInfoBean, BaseViewHolder> {

    public HomeWinInformationAdapter(List<WinInfoBean> data) {
        super(R.layout.home_win_information_item, data);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, final WinInfoBean winInfo) {
        if (viewHolder.getLayoutPosition() % 2 == 0) {
            viewHolder.setBackgroundColor(R.id.ll_home_win_information_item, Color.parseColor("#ffffff"));
        } else {
            viewHolder.setBackgroundColor(R.id.ll_home_win_information_item, Color.parseColor("#f1f1f1"));
        }

        BigDecimal prize = new BigDecimal(winInfo.getPrize());
        viewHolder.setText(R.id.win_info_item_login_name_tv, Html.fromHtml(mContext.getString(R.string.home_win_information_item_content, winInfo.getUserName(), winInfo.getPlatform(), winInfo.getGameName(), winInfo.getBetAmt(), prize.toPlainString())));
    }


}
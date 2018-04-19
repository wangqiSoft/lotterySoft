package com.lotterytechnology.lottery.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
* @author Ryder
* create at 2018/4/19 16:29
 * package name:com.lotterytechnology.lottery.widget
* description: 首页滚动中奖信息的控件
**/

public class CustomTouchRecyclerView extends RecyclerView {

    private OnActionUpListener mOnActionUpListener;

    public CustomTouchRecyclerView(Context context) {
        super(context);
    }

    public CustomTouchRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTouchRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    public boolean onTouchEvent(MotionEvent e) {
        super.onTouchEvent(e);
        if (e.getAction() == MotionEvent.ACTION_UP) {
            if (mOnActionUpListener != null) {
                mOnActionUpListener.onActionUp();
            }
            return true;
        }
        return true;
    }


    public void setActionUpListener(OnActionUpListener actionUpListener) {
        this.mOnActionUpListener = actionUpListener;
    }


    public interface OnActionUpListener {
        void onActionUp();
    }
}

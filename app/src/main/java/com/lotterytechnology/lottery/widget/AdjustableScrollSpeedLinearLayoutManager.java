package com.lotterytechnology.lottery.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

/**
* @author Ryder
* create at 2018/4/19 16:39
 * package name:com.lotterytechnology.lottery.widget
* description: 首页滚动recycle 的manager
**/
public class AdjustableScrollSpeedLinearLayoutManager extends LinearLayoutManager {

    private float speed;

    public AdjustableScrollSpeedLinearLayoutManager(Context context) {
        super(context);
    }

    public AdjustableScrollSpeedLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public AdjustableScrollSpeedLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        CustomLinearSmoothScroller linearSmoothScroller = new CustomLinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }


    class CustomLinearSmoothScroller extends LinearSmoothScroller {

        public CustomLinearSmoothScroller(Context context) {
            super(context);
        }

        @Override
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return speed / displayMetrics.densityDpi;
        }

        @Override
        protected int calculateTimeForScrolling(int dx) {
            return super.calculateTimeForScrolling(dx);
        }
    }

}

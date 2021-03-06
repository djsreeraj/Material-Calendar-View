package com.applandeo.materialcalendarview.builders;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.listeners.OnSelectionAbilityListener;

/**
 * This class is using to create CalendarView instance
 * Created by Mateusz Kornakiewicz on 12.10.2017.
 */

public class CalendarBuilder {
    private Context mContext;
    private int mCalendarType = CalendarView.CLASSIC;
    private int mHeaderColor;
    private int mHeaderLabelColor;
    private int mPreviousButtonSrc;
    private int mForwardButtonSrc;
    private int mSelectionColor;
    private int mTodayLabelColor;
    private String[] mMonthsNames;
    private int mDaysNames;
    private OnSelectionAbilityListener mOnSelectionAbilityListener;

    public CalendarBuilder(Context context) {
        mContext = context;
    }

    private CalendarView build() {
        return new CalendarView(mContext, mCalendarType, mHeaderColor, mHeaderLabelColor,
                mPreviousButtonSrc, mForwardButtonSrc, mSelectionColor, mTodayLabelColor,
                mMonthsNames, mDaysNames, mOnSelectionAbilityListener);
    }

    @Deprecated
    public CalendarBuilder datePicker(boolean isDatePicker) {
        if (isDatePicker) {
            mCalendarType = CalendarView.ONE_DAY_PICKER;
        }

        return this;
    }

    public CalendarBuilder setType(int calendarType) {
        mCalendarType = calendarType;
        return this;
    }

    public CalendarBuilder headerColor(@ColorRes int color) {
        mHeaderColor = color;
        return this;
    }

    public CalendarBuilder headerLabelColor(@ColorRes int color) {
        mHeaderLabelColor = color;
        return this;
    }

    public CalendarBuilder previousButtonSrc(@DrawableRes int drawable) {
        mPreviousButtonSrc = drawable;
        return this;
    }

    public CalendarBuilder forwardButtonSrc(@DrawableRes int drawable) {
        mForwardButtonSrc = drawable;
        return this;
    }

    public CalendarBuilder selectionColor(@ColorRes int color) {
        mSelectionColor = color;
        return this;
    }

    public CalendarBuilder todayLabelColor(@ColorRes int color) {
        mTodayLabelColor = color;
        return this;
    }

    public CalendarBuilder monthsNames(@ArrayRes int names) {
        if (names != 0) {
            mMonthsNames = mContext.getResources().getStringArray(names);
        }

        return this;
    }

    public CalendarBuilder daysNames(@ArrayRes int names) {
        mDaysNames = names;
        return this;
    }

    public CalendarBuilder selectionAbilityListener(OnSelectionAbilityListener onSelectionAbilityListener) {
        mOnSelectionAbilityListener = onSelectionAbilityListener;
        return this;
    }

    public CalendarView create() {
        return build().create();
    }
}

package com.jackson.ssrjmvp.adapter; /**
 * BaseDelegateAdapter  2018-07-19
 * Copyright (c) 2018 JS Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * class description here
 *
 * @author Jackson
 * @version 1.0.0
 *          since 2018 07 19
 */
public abstract class BaseDelegateAdapter<T, K extends BaseViewHolder> extends DelegateAdapter.Adapter<K> {

    private LayoutHelper mLayoutHelper;
    private int mCount = -1;
    private int mLayoutId = -1;
    protected Context mContext;
    private List<T> mDataList;

    /**
     * 构造方法
     *
     * @param context
     * @param layoutHelper
     * @param lauoutId
     * @param
     */
    protected BaseDelegateAdapter(Context context, List<T> list, LayoutHelper layoutHelper, int lauoutId, int count) {
        this.mContext = context;
        this.mDataList = list;
        this.mLayoutHelper = layoutHelper;
        this.mLayoutId = lauoutId;
        this.mCount = count;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @Override
    public K onCreateViewHolder(ViewGroup parent, int viewType) {
     //   this.mContext = parent.getContext();
        return (K) new BaseViewHolder(LayoutInflater.from(mContext).inflate(mLayoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(K holder, int position) {
        convert(holder, getItem(position));
    }


    @Override
    public int getItemCount() {
        return mCount;
    }

    protected abstract void convert(K helper, T item);

    @Nullable
    public T getItem(@IntRange(from = 0) int position) {
        if (position < mDataList.size())
            return mDataList.get(position);
        else
            return null;
    }

}


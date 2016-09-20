package cn.com.dareway.dwandroidcoursedemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import cn.com.dareway.dwandroidcoursedemo.model.News;

/**
 * description:
 * DwAndroidCourseDemo : 55:
 * Created by chengz on 2016/9/19.
 * Copyright (c) 2016.DareWay  Inc. All rights reserved.
 */
public class NewsAdapter extends BaseAdapter {
    private List<News> newsList;
    private Context context;
    private LayoutInflater inflater;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    static class ViewHolder {


    }

}

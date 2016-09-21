package cn.com.dareway.dwandroidcoursedemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.com.dareway.dwandroidcoursedemo.R;
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_news, viewGroup, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        News news = newsList.get(i);
        viewHolder.tvTitle.setText(news.getTitle());
        viewHolder.tvDate.setText(news.getPubTime());
        return convertView;
    }

    private static class ViewHolder {
        TextView tvTitle, tvDate;

        private ViewHolder(View view) {
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvDate = (TextView) view.findViewById(R.id.tv_date);
        }
    }
}

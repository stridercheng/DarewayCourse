package cn.com.dareway.dwandroidcoursedemo.ui.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.com.dareway.dwandroidcoursedemo.R;
import cn.com.dareway.dwandroidcoursedemo.model.Message;

/**
 * description:
 * DwAndroidCourseDemo : 40:
 * Created by chengz on 2016/9/18.
 * Copyright (c) 2016.DareWay  Inc. All rights reserved.
 */
public class MessageAdapter extends BaseAdapter {
    private List<Message> messageList;
    private Context context;
    private LayoutInflater inflater;

    public MessageAdapter(Context context, List<Message> messageList) {

        this.context = context;
        this.messageList = messageList;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int i) {
        return messageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_message, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Message message = messageList.get(i);
        viewHolder.tv_title.setText(message.getTitle());
        viewHolder.tv_content.setText(message.getContent());
        return convertView;
    }

    static class ViewHolder {
        TextView tv_title, tv_content;

        public ViewHolder(View view) {
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_content = (TextView) view.findViewById(R.id.tv_content);
        }
    }
}

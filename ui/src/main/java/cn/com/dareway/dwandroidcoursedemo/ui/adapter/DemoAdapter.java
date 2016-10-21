package cn.com.dareway.dwandroidcoursedemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.com.dareway.dwandroidcoursedemo.R;
import cn.com.dareway.dwandroidcoursedemo.model.Message;

/**
 * Created by Administrator on 2016/10/13.
 */

public class DemoAdapter extends BaseAdapter {
    private List<Message> messageList;
    private LayoutInflater inflater;

    public DemoAdapter(List<Message> messageList, Context context){
        this.messageList = messageList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        View view = inflater.inflate(R.layout.item_message, null);
//
//        ImageView iv = (ImageView) view.findViewById(R.id.iv_avatar);
//        TextView tv = (TextView) view.findViewById(R.id.tv_title);
//
//        Message message = messageList.get(position);
//
//        tv.setText(message.getTitle());
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_message, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Message message = messageList.get(position);
        viewHolder.tv_title.setText(message.getTitle());

        return convertView;
    }

    class ViewHolder  {
        TextView tv_title;
        public ViewHolder(View itemView){
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}

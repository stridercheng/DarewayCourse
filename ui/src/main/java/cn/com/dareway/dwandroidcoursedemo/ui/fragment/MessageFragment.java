package cn.com.dareway.dwandroidcoursedemo.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import cn.com.dareway.dwandroidcoursedemo.R;
import cn.com.dareway.dwandroidcoursedemo.model.Message;
import cn.com.dareway.dwandroidcoursedemo.ui.adapter.MessageAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends Fragment {

    public MessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MessageFragment.
     */
    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }


    RadioButton rb_message, rb_telephone;
    ListView list_message;
    MessageAdapter messageAdapter;
    String[] names = new String[]{
            "奥巴马","普京","习近平","李克强","王思聪","马云","王健林",
            "奥巴马","普京","习近平","李克强","王思聪","马云","王健林",
            "奥巴马","普京","习近平","李克强","王思聪","马云","王健林",
            "奥巴马","普京","习近平","李克强","王思聪","马云","王健林",
            "奥巴马","普京","习近平","李克强","王思聪","马云","王健林"
    };

    String[] contents = new String[]{
            "今晚有空吗，一起吃饭？","周天一起去钓鱼吧！","你好，交个朋友呗"
    };

    List<Message> messageList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        rb_message = (RadioButton) view.findViewById(R.id.rb_message);
        rb_message.setChecked(true);

        list_message = (ListView) view.findViewById(R.id.list_message);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }


    private void initView() {
        for (int i = 0; i < 30; i++) {
            Message message = new Message(i, names[i], contents[i%3], "2016/09/18");
            messageList.add(message);
        }

        messageAdapter = new MessageAdapter(getActivity(), messageList);
        list_message.setAdapter(messageAdapter);
    }
}

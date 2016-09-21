package cn.com.dareway.dwandroidcoursedemo.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.com.dareway.dwandroidcoursedemo.R;
import cn.com.dareway.dwandroidcoursedemo.model.News;
import cn.com.dareway.dwandroidcoursedemo.ui.activity.NewsDetailActivity;
import cn.com.dareway.dwandroidcoursedemo.ui.adapter.NewsAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SpaceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpaceFragment extends Fragment {
    private final static String MOBKEY = "16bc3663defb4";
    private String newsUrl = "http://apicloud.mob.com/wx/article/search?key=16bc3663defb4&cid=5";

    private List<News> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;
    public SpaceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SpaceFragment.
     */
    public static SpaceFragment newInstance() {
        SpaceFragment fragment = new SpaceFragment();
        return fragment;
    }

    ListView list_news;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_space, container, false);
        list_news = (ListView) view.findViewById(R.id.list_news);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getNews();
            }
        }).start();

        list_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("url", newsList.get(position).getSourceUrl());
                intent.setClass(getActivity(), NewsDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    //在子线程里访问网路，获取数据
    private void getNews() {
        try {
            URL url = new URL(newsUrl + "&page=1&size=20");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream is = httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            JSONObject response = new JSONObject(sb.toString());
            if ("200".equals(response.getString("retCode"))) {
                JSONObject result = response.getJSONObject("result");
                newsList = new Gson().fromJson(result.getString("list"), new TypeToken<List<News>>() {
                }.getType());
            }

            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //刷新UI
    private void loadData() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                newsAdapter = new NewsAdapter(getActivity(), newsList);
                list_news.setAdapter(newsAdapter);
            }
        });
    }
}

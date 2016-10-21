package cn.com.dareway.record;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
//
//    //http://android.jobbole.com/82096/?utm_medium=referral
//    private ListView listView;
//    private static final String[] strs = new String[] {
//        "one", "two", "three", "four", "five",
//            "one", "two", "three", "four", "five",
//            "one", "two", "three", "four", "five",
//            "one", "two", "three", "four", "five",
//    };
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        https://vplscdn.videojj.com/video/experience.mp4

        vv = (VideoView) findViewById(R.id.vv);
        Uri uri = Uri.parse("https://vplscdn.videojj.com/video/experience.mp4");
        vv.setMediaController(new MediaController(this));
        vv.setVideoURI(uri);
        vv.requestFocus();

    }
}

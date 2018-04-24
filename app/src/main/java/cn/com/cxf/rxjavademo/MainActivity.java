package cn.com.cxf.rxjavademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import cn.com.cxf.rxjavademo.Event.MessageEvent;
import cn.com.cxf.rxjavademo.rxbus.EventInfo;
import cn.com.cxf.rxjavademo.rxbus.RxBus;
import cn.com.cxf.rxjavademo.rxbus.RxEvent;

public class MainActivity extends Activity {
    private TextView textView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

//        EventBus.getDefault().register(this);
        RxBus.getInstance().register(RxEvent.NoticeEvent.FIRST_URL,this);

    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(MessageEvent messageEvent){
//        textView.setText(messageEvent.getMessage());
//    }

    public void onRxEvent(RxEvent event, EventInfo info) {
        Log.i("MainActivity", "onRxEvent event:" + event + ",info:" + info);
        textView.setText("rxbus notivice"+info.getIndex());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(RxEvent.NoticeEvent.FIRST_URL,this);

//        EventBus.getDefault().unregister(this);
    }
}

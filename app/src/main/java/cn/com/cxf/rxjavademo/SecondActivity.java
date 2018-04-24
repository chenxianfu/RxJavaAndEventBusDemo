package cn.com.cxf.rxjavademo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import cn.com.cxf.rxjavademo.rxbus.EventInfo;
import cn.com.cxf.rxjavademo.rxbus.RxBus;
import cn.com.cxf.rxjavademo.rxbus.RxEvent;


/**
 * @auther: Created by cxf on 2018/4/23.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class SecondActivity extends AppCompatActivity {
    private TextView tv_receive;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_receive = findViewById(R.id.tv_receive);
        tv_receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EventBus.getDefault().post(new MessageEvent("发送成功"));
                RxBus.getInstance().send(RxEvent.NoticeEvent.FIRST_URL,new EventInfo(10));
                finish();
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

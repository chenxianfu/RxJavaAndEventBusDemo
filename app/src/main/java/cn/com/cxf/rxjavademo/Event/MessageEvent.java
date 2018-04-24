package cn.com.cxf.rxjavademo.Event;

/**
 * @auther: Created by cxf on 2018/4/23.
 * @email: chenxianfu_it@163.com
 * @title:
 * @description:
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

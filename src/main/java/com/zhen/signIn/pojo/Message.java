package com.zhen.signIn.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiJiaZhen
 * @date 2021/9/28 16:07
 *
 * 信息类，用于返回数据已经所需的信息
 */
public class Message {
    //200:成功 201：失败
    private int code;
    //信息
    private Map<String,Object> msg = new HashMap<>();
    //要传输的数据
    private Map<String,Object> extend = new HashMap<>();

    public Message() {
    }
    public static Message success(String mes){
        Message message = new Message();
        message.msg.put("mes",mes);
        message.code = 200;
        return message;
    }
    public static Message fail(String mes){
        Message message = new Message();
        message.msg.put("mes",mes);
        message.code = 201;
        return message;
    }
    /**
     * 添加数据
     * @param name
     * @param date
     * @return
     */
    public Message add(String name,Object date){
        this.extend.put(name,date);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, Object> msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}

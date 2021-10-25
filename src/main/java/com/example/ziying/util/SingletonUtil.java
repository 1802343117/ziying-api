package com.example.ziying.util;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 12559
 * 使用单例模型管理通信用户
 */
public class SingletonUtil {

    // 静态的 UserUtils 表明该对象只有一个
    private static SingletonUtil singletonUtil;

    // 用户通信容器
    private List<Session> list;

    /**
     * 仅允许创建一次该类对象
     * @return singletonUtil
     */
    public static synchronized SingletonUtil getSingletonUtil() {
        if ( singletonUtil == null ) {
            singletonUtil = new SingletonUtil();
        }
        return singletonUtil;
    }

    /**
     * 无参构造器，提供参加该类对象
     * 在创建对象的同时 创建存储空间
     */
    private SingletonUtil() {
        this.list = new ArrayList<>();
    }

    /**
     * 添加通信用户
     * @param session
     */
    public synchronized void addSingletonUtil(Session session) {
        this.list.add(session);
    }

    /**
     * 消息群发
     * @param msg
     */
    public synchronized void qunfa(String msg) {
        for (int i = 0; i < list.size(); i++) {
            try {
                System.out.println(this.list.get(i).toString());
                this.list.get(i).getBasicRemote().sendText(msg);
            } catch (Exception e) {
                e.printStackTrace();
                // 即便出现错误 程序依然继续执行不会被终止
                continue;
            }
        }
    }

    /**
     * 删除已退出通信的用户
     * */
    public synchronized void delete(Session session) {
        Iterator<Session> it = this.list.iterator();
        while(it.hasNext()){
            Session sess = (Session)it.next();
            if(session.equals(sess)){
                it.remove();
            }
        }
        System.out.println(this.list.toString());
    }
}

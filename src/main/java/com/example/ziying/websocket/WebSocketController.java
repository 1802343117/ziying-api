package com.example.ziying.websocket;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ziying.controller.MovieCommentController;
import com.example.ziying.domain.entity.MovieComment;
import com.example.ziying.service.MovieCommentService;
import com.example.ziying.service.impl.MovieCommentServiceImpl;
import com.example.ziying.util.SingletonUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author 12559
 */
@Component
@ServerEndpoint("/websocket")
public class WebSocketController {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("连接成功");
        SingletonUtil singletonUtil = SingletonUtil.getSingletonUtil();
        singletonUtil.addSingletonUtil(session);
    }

    /**
     * 接收到客户端发送的数据时被调用
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("我接收到的信息：" + message);
//        JSONObject mess = JSONObject.parseObject(message);
//        System.out.println(mess.getString("sign"));
        // 群发消息
        SingletonUtil singletonUtil = SingletonUtil.getSingletonUtil();
        singletonUtil.qunfa(message);
    }

    /**
     * 连接关闭时被调用
     *
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("我关闭了通信连接");
        SingletonUtil singletonUtil = SingletonUtil.getSingletonUtil();
        singletonUtil.delete(session);
    }
}

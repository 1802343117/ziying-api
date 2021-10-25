package com.example.ziying.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.data.redis.listener.Topic;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wl_sun
 * @description 使用HttpClient和JSoup实现爬虫，爬取掘金的topic页面
 * @create Date
 */
public class JueJinSpider {
    private static final Integer SUCCESS = 200;

    public static List<Topic> getTopics(){
        List<Topic> topics = new ArrayList<>();
        //目标地址
        String url = "http://ivi.bupt.edu.cn";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get,context);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(response.getStatusLine());


//        如果请求成功，则获取网页源码
        if(response.getStatusLine().getStatusCode() == SUCCESS){
            //获取响应对象实体，并转成UTF-8字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity,"UTF-8");
            }catch (IOException e){
                e.printStackTrace();
            }

            System.out.println(res);

            JSONObject jsonObject = JSONObject.parseObject(res);
//            System.out.println(jsonObject);
//            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
//            list.forEach(o -> {
//                JSONObject json = JSONObject.parseObject(o.toString());
//                Topic topic = Topic.builder()
//                        .id(json.getString("objectId"))
//                        .topicName(json.getString("title"))
//                        .topicIcon(json.getString("icon"))
//                        .description(json.getString("description"))
//                        .megCount(json.getInteger("msgsCount"))
//                        .followersCount(json.getInteger("followersCount"))
//                        .followed(json.getBoolean("followed"))
//                        .build();
//                topics.add(topic);
//            });
        }
        else {
            System.out.println("请求失败");
        }
//        try {
//            response.close();
//            httpClient.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        return topics;
    }

    public static void main(String[] args) {
        getTopics();
    }
}

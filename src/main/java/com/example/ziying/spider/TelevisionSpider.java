package com.example.ziying.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ziying.domain.entity.Television;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
public class TelevisionSpider {
    private  static  final Integer SUCCESS = 200;

    public static <elements> List<Television> getTelevisionList(){
        List<Television> books = new ArrayList<>();
        //目标地址
        String url = "http://ivi.bupt.edu.cn";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(get,context);
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(response.getStatusLine());

        if(response.getStatusLine().getStatusCode() == SUCCESS){
            HttpEntity entity = response.getEntity();
            String res = null;
            try{
                res = EntityUtils.toString(entity,"UTF-8");
            }catch (IOException e){
                e.printStackTrace();
            }

//            System.out.println(res);

            Document document = Jsoup.parse(res);
//            System.out.println(document);


            Elements elements =  document.select("div[class=2u]");
//            System.out.println(elements);

            for(int i = 0; i < elements.size();i++) {
                Television television = new Television();
                Element e = elements.get(i);
                System.out.println(i);
//                System.out.println(e);

                String title = e.select("p").text();
                System.out.println(title);
                television.setTelevisionName(title);

                Elements img = e.select("a[class=icon1]");
//                System.out.println(img);

                for (int j = 0; j < img.size(); j++) {
                    Element imge = img.get(j);
                    if( imge.hasAttr("href") ){
                        String str = imge.attr("href");
                        String image = url + str;
                        System.out.println(image);
                        if ( j == 0 ) {
                            television.setTelevisionPcUrl(image);
                        } else {
                            television.setTelevisionMobileUrl(image);
                        }
                    } else {
                        System.out.println("无");
                    }
                }

                books.add(television);
            }
        }
        else {
            System.out.println("请求失败");
        }
        try {
            response.close();
            httpClient.close();
        }catch (IOException e) {
            e.printStackTrace();
       }

        return books;
    }

    public static void main(String[] args) {
        System.out.println(getTelevisionList());
    }
}

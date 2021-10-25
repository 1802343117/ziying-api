package com.example.ziying.spider;

import com.example.ziying.domain.entity.CartoonInfor;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartoonSpider {

    private  static  final Integer SUCCESS = 200;

    // url 为 目标地址
    public static <elements> List<CartoonInfor> getCartoonList(String url){
        List<CartoonInfor> books = new ArrayList<>();

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

            Elements elements =  document.select("div[class=myui-panel_bd]").select("ul").select("li").select("div[class=myui-vodlist__box]").select("a[class=myui-vodlist__thumb]");
//            System.out.println(elements);

            for (int i  = 0; i < elements.size(); i++) {
                CartoonInfor cartoonInfor = new CartoonInfor();

                Element element = elements.get(i);
                String src = element.attr("href");
//                System.out.println(src);
                String address = "http://www.zhoumody.com" + src;

                Document doc = Jsoup.parse(simulation(address));
//                System.out.println(doc);

                Elements elemImg = doc.select("div[class=col-xs-1]").select("div[class=myui-content__thumb]").select("img");
//                System.out.println(elem);
                String strImg = elemImg.attr("data-original");
                System.out.println("http://www.zhoumody.com" + strImg);

                Elements elemInfor = doc.select("div[class=col-xs-1]").select("div[class=myui-content__detail]");
                String strTitle = elemInfor.select("h1").text();
                System.out.println(strTitle);

                String strScore = elemInfor.select("div[id=rating]").select("span[class=branch ff-score-val]").text();
                System.out.println(strScore);

                Elements eleRpldi = elemInfor.select("p[class=data]");
//                System.out.println(eleRpl);
                for (int j = 0; j < eleRpldi.size(); j++) {
                    Element elementRpl = eleRpldi.get(j);
                    switch (j) {
                        case 0:
                            Elements e = elementRpl.select("a");
//                            System.out.println(e);
                            List<String> cate = new ArrayList<>();
                            for (int z = 0; z < e.size(); z++  ) {
                                Element eleRpl = e.get(z);
                                if ( z == e.size()-1 ) {
                                    String release = eleRpl.text();
                                    System.out.print("年份：");
//                                    System.out.println(release);
                                    cartoonInfor.setCartoonRelease(release);
                                }
                                if ( z == e.size()-2 ) {
                                    String place = eleRpl.text();
                                    System.out.print("地区：");
//                                    System.out.println(place);
                                    cartoonInfor.setCartoonPlace(place);
                                }
                                if ( z != e.size()-1 && z != e.size()-2 ) {
                                    cate.add(eleRpl.text());
                                }
                            }
                            String category = "";
                            for ( String x: cate ) {
                                category += x + " ";
                            }
//                            System.out.println(category);
                            cartoonInfor.setCartoonCategory(category);
                            break;
                        case 1:
                            String leading = elementRpl.select("a").text();
                            System.out.print("主演：");
//                            System.out.println(leading);
                            cartoonInfor.setCartoonLeading(leading);
                            break;
                        case 2:
                            String director = elementRpl.select("a").text();
                            System.out.print("导演：");
//                            System.out.println(director);
                            cartoonInfor.setCartoonDirector(director);
                            break;
                    }
                }

                String strIntro = elemInfor.select("p[class=data hidden-xs]").select("a").attr("onclick");
                String arr [] = strIntro.split("'");
//                System.out.println(arr[1]);
                cartoonInfor.setCartoonIntro(arr[1]);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

                cartoonInfor.setLinkId(0);
                cartoonInfor.setCommentId(0);
                cartoonInfor.setCartoonCover("http://www.zhoumody.com" + strImg);
                cartoonInfor.setCartoonName(strTitle);
                cartoonInfor.setCartoonScore(Float.parseFloat(strScore));
                books.add(cartoonInfor);
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

    //url 目标地址
    public static String simulation(String url) {

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

        String res = null;

        if(response.getStatusLine().getStatusCode() == SUCCESS){
            HttpEntity entity = response.getEntity();
            try{
                res = EntityUtils.toString(entity,"UTF-8");
            }catch (IOException e){
                e.printStackTrace();
            }
            return res;
        } else {
            res = "请求失败";
        }
        try {
            response.close();
            httpClient.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        String url = "http://www.zhoumody.com/type2/-----addtime-2.html";
        System.out.println(getCartoonList(url));
    }
}

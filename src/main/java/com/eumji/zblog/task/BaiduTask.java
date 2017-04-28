package com.eumji.zblog.task;

import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.vo.Article;
import jdk.internal.dynalink.beans.StaticClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * FILE: com.eumji.zblog.task.BaiduTask.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/28
 * TIME: 20:23
 */
@Component
public class BaiduTask {
    public static final String POST_URL = "http://data.zz.baidu.com/urls?site=www.eumji025.com&token=hHzO6TjfJBf4KA53";
    public static final String BASE_URL = "http://www.eumji025.com";
    @Autowired
    private ArticleService articleService;

    @Scheduled(fixedDelay = 5000000)
    public void postArticleUrl(){
        PrintWriter out=null;
        try {
            URLConnection conn = new URL(POST_URL).openConnection();
            conn.setRequestProperty("Host","data.zz.baidu.com");
            conn.setRequestProperty("User-Agent", "curl/7.12.1");
            conn.setRequestProperty("Content-Length", "83");
            conn.setRequestProperty("Content-Type", "text/plain");

            conn.setDoInput(true);
            conn.setDoOutput(true);
            String [] ids = articleService.getArticleId();
            int length = ids.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++){
                sb.append(BASE_URL+"/article/details/"+ids[i]+"\n");
            }
            System.out.println("推送的url为:"+sb.toString());
            out=new PrintWriter(conn.getOutputStream());
            out.print(sb.toString().trim());

        } catch (MalformedURLException e) {
            System.out.println("推送发生错误!!!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("推送发生错误!!!");
            e.printStackTrace();
        }
    }
}

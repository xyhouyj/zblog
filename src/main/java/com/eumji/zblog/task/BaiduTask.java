package com.eumji.zblog.task;

import com.eumji.zblog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String POST_URL = "http://data.zz.baidu.com/urls?site=www.eumji025.com&token=hHzO6TjfJBf4KA53";
    public static final String BASE_URL = "http://www.eumji025.com";
    @Autowired
    private ArticleService articleService;

    private URLConnection initConnect() throws IOException {
        URLConnection conn = new URL(POST_URL).openConnection();
        conn.setRequestProperty("Host","data.zz.baidu.com");
        conn.setRequestProperty("User-Agent", "curl/7.12.1");
        conn.setRequestProperty("Content-Length", "83");
        conn.setRequestProperty("Content-Type", "text/plain");

        conn.setDoInput(true);
        conn.setDoOutput(true);
        return conn;
    }
    @Scheduled(fixedDelay = 2000000)
    public void postArticleUrl() throws IOException {
        String [] ids = articleService.getArticleId();
       writerUrl(initConnect(),ids);

    }

    /**
     * 重构推送文章的write方法
     * @param conn
     * @param ids
     * @throws IOException
     */
    private void writerUrl(URLConnection conn,String... ids) throws IOException {
        PrintWriter out=null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ids.length; i++){
            sb.append(BASE_URL+"/article/details/"+ids[i]+"\n");
        }
        logger.info("推送的url为:"+sb.toString());
        out=new PrintWriter(conn.getOutputStream());
        out.print(sb.toString().trim());
        out.close();
    }

    /**
     * 新增添加文章推送功能
     * @param articleId 文章id
     */
    public void pushOneArticle(String articleId) throws IOException {
        writerUrl(initConnect(),articleId);

    }
}

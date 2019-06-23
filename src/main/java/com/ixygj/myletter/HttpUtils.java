package com.ixygj.myletter;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 页面下载工具类
 */
public class HttpUtils {
    //获取页面内容
    public static String getPageContent(String url) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        String content = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            content = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}

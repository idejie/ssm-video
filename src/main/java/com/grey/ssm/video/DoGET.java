package com.grey.ssm.video;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoGET {
    public static List<String> getPic(String url) throws Exception {
        List<String> ret = new ArrayList<>();
        try {
            Connection.Response res = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(10000).ignoreContentType(true).execute();//.get();
            String body = res.body();
//            System.out.println(body);
            JSONObject jsonObject = JSONObject.parseObject(body);
            System.out.println();
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
//                System.out.println(object.getString("img"));
                ret.add(object.getString("img"));
            }
//            JSONObject json = JSONObject.fromObject(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String i :ret){
            System.out.println(i);
        }
        return ret;
    }
}

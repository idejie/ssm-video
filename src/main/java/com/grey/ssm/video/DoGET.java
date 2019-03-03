package com.grey.ssm.video;

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
        try
        {
            Document document = Jsoup.connect(url).get();
            Elements elements =  document.getElementsByTag("img");
            for(Element e : elements){
                if(e.attr("data-src").contains("http")){
                    System.out.println(e.attr("data-src"));
                    ret.add(e.attr("data-src"));
                }else{
//                    System.out.println("null");
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return ret;
    }
}

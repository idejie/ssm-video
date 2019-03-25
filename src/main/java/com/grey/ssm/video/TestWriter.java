package com.grey.ssm.video;

import com.grey.ssm.video.utils.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestWriter {
    public static void main(String[] args) {
        writeFile("这个","./ss");
    }
    public static void writeFile(String content,String path) {
//        FileWriter writer;
        try {
            File file1 = new File(path);
            Writer writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file1), "UTF-8"));
            writer.write("");//清空原文件内容
            writer.write(content);
            writer.flush();
            writer.close();
            System.out.println("completed:"+path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

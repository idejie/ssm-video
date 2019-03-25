package com.grey.ssm.video.web;

import com.alibaba.fastjson.JSONObject;
import com.grey.ssm.video.DoGET;
import com.grey.ssm.video.TestWriter;
import com.grey.ssm.video.model.Resource;
import com.grey.ssm.video.model.User;
import com.grey.ssm.video.model.Video;
import com.grey.ssm.video.service.MyService;
import com.grey.ssm.video.utils.Constants;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MyService myService;
    //    private static User cur_user;
    private static User cur_admin;

    //首页
    @RequestMapping("/")
    private void index(HttpServletRequest req, HttpServletResponse res) throws Exception {

        req.getRequestDispatcher(Constants.DIR_HOME + "index.jsp");
    }

    //开始
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    private void start(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher(Constants.DIR_HOME + "login.jsp").forward(req, res);
        } else {
            res.sendRedirect("/history/" + user.getU_id());
        }

    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private void login(HttpServletRequest req, HttpServletResponse res) throws Exception {
        File f = new File("res/1.txt");
        System.out.println(f.getAbsolutePath());

        HttpSession session = req.getSession();

        req.setAttribute("error", session.getAttribute("error"));
        session.removeAttribute("error");
//        System.out.println("#######sssss");
        req.getRequestDispatcher(Constants.DIR_HOME + "login.jsp").forward(req, res);


    }
    //登录动作
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private void loginAction(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("###username:" + username + " ###password:" + password);
        HttpSession session = req.getSession();
        User user = myService.getUserByName(username);

        if (user == null) {
            session.setAttribute("error", "无此用户");
            res.sendRedirect("/login");
        } else if (!user.getPassword().equals(password)) {
            System.out.println(user.toJSON());
            session.setAttribute("error", "密码错误");
            res.sendRedirect("/login");
        } else {
            System.out.println(user.toJSON());

            session.setAttribute("user", user);
            res.sendRedirect("/history/" + user.getU_id());
        }

    }

    //登出
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private void logoutAction(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        session.removeAttribute("error");
        session.removeAttribute("user");
        session.removeAttribute("admin");
        res.sendRedirect("/");


    }

    //注册
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    private void sign(HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();

        req.setAttribute("error", session.getAttribute("error"));
        session.removeAttribute("error");
        req.getRequestDispatcher(Constants.DIR_HOME + "sign.jsp").forward(req, res);


    }

    //注册动作
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    private void signAction(HttpServletRequest req, HttpServletResponse res) throws Exception {

//        int u_id = Integer.parseInt(req.getParameter("u_id"));
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        HttpSession session = req.getSession();
        User user = myService.getUserByName(username);

        if (user != null) {
            System.out.println(user.toJSON());
            session.setAttribute("error", "已有此用户");
            res.sendRedirect("/sign");
        } else if (!password1.equals(password2)) {
            session.setAttribute("error", "密码不一致");
            res.sendRedirect("/sign");
        } else {

            myService.addUser(username, password1);
            User newUser = myService.getUserByName(username);
            session.setAttribute("user", newUser);
//            cur_user=newUser;
            res.sendRedirect("/history/" + user.getU_id());
        }

    }

    //管理员登录
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    private void admin(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();

        req.setAttribute("error", session.getAttribute("error"));
        session.removeAttribute("error");
        System.out.println("#######sssss");
        req.getRequestDispatcher(Constants.DIR_HOME + "admin.jsp").forward(req, res);
    }

    //管理登录动作
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    private void adminAction(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String username = req.getParameter("admin");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User admin = myService.getUserByName(username);

        if (admin == null) {
            session.setAttribute("error", "无此用户");
            res.sendRedirect("/admin");
        } else if (!admin.getPassword().equals(password)) {
            System.out.println(admin.toJSON());
            session.setAttribute("error", "密码错误");
            res.sendRedirect("/admin");
        } else {
            if (admin.getUsername().equals("admin")) {
                System.out.println(admin.toJSON());
                session.setAttribute("admin", admin);
                cur_admin = admin;
                res.sendRedirect("/manage");
            } else {
                session.setAttribute("error", "非管理员");
                res.sendRedirect("/admin");
            }

        }

    }

    //管理员管理
    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    private void manage(HttpServletRequest req, HttpServletResponse res) throws Exception {

        HttpSession session = req.getSession();

        req.setAttribute("user", session.getAttribute("user"));
        session.removeAttribute("user");
        List<User> allUsers = myService.getAllUsers();
        req.setAttribute("allUsers", allUsers);
        for (User u :
                allUsers) {
            System.out.println(u.toJSON());
        }
        req.getRequestDispatcher(Constants.DIR_HOME + "manage.jsp").forward(req, res);
    }



    //用户删除
    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    private void delUser(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res) throws Exception {
        myService.delUser(id);
        res.sendRedirect("/manage");


    }

    //用户授权
    @RequestMapping(value = "/yes/{id}", method = RequestMethod.GET)
    private void yesUser(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res) throws Exception {
        myService.yesUser(id);
        res.sendRedirect("/manage");


    }

    //取消授权
    @RequestMapping(value = "/no/{id}", method = RequestMethod.GET)
    private void noUser(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res) throws Exception {
        myService.noUser(id);
        res.sendRedirect("/manage");


    }


    //历史记录

    @RequestMapping(value = "/history/{id}", method = RequestMethod.GET)
    private void history(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();
//        System.out.println("s);
//        User user = (User) session.getAttribute("user");
        User user = myService.getUserByID(id);


        req.setAttribute("user", user);


        session.removeAttribute("user");
        session.setAttribute("user", user);
        List<Video> videos = myService.getUserVideo(user.getU_id());
        List<Video> videoFull = new ArrayList<Video>();
        List<Video> videoUnFull = new ArrayList<Video>();
        for (Video v : videos) {
            if (v.getIs_full() == 1) {
                videoFull.add(v);
            } else {
                videoUnFull.add(v);
            }
        }
        req.setAttribute("videos", videoFull);
        req.setAttribute("videos2", videoUnFull);
        System.out.println(user.toJSON());
        if (user.getPermisson() != 1) {
            session.setAttribute("error", "请联系管理员授权");
            res.sendRedirect("/login");
        } else {
            session.removeAttribute("user");
            req.getRequestDispatcher(Constants.DIR_HOME + "history.jsp").forward(req, res);

        }

    }

    //视频制作
    @RequestMapping(value = "/add-video/{id}", method = RequestMethod.GET)
    private void addVideo(@PathVariable("id") int u_id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();

        req.setAttribute("user", session.getAttribute("user"));
        session.removeAttribute("user");
        myService.newVideo(u_id);
        List<Video> videos = myService.getUserVideo(u_id);
        int v_id = 0;
        for (Video v :
                videos) {
            if (v.getV_id() > v_id)
                v_id = v.getV_id();
        }
        res.sendRedirect("/v/" + v_id);


    }

    @RequestMapping(value = "/v/{v_id}", method = RequestMethod.GET)
    private void detailVideo(@PathVariable("v_id") int v_id, HttpServletRequest req, HttpServletResponse res) throws Exception {
        Video v = myService.getVideo(v_id);
        User user = myService.getUserByID(v.getU_id());
        System.out.println(user.toJSON());
        List<Resource> resources = myService.getRes(v_id);
        req.setAttribute("video", v);
        req.setAttribute("user", user);
        req.setAttribute("res", resources);
        req.getRequestDispatcher(Constants.DIR_HOME + "video.jsp").forward(req, res);
    }
    //其他操作

    //视频删除
    @RequestMapping(value = "/del-video/{id}", method = RequestMethod.GET)
    private void delVideo(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();
        Video v = myService.getVideo(id);

        myService.delVideo(id);
        req.setAttribute("user", session.getAttribute("user"));
        res.sendRedirect("/history/" + v.getU_id());



    }

    //视频更新

    //选择图片
    @RequestMapping(value = "/v/{v_id}/add-pic", method = RequestMethod.GET)
    private void addPic(@PathVariable("v_id") int v_id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        String keyword = req.getParameter("keyword");
        Video v = myService.getVideo(v_id);

        String url = "http://image.so.com/j?q=" + keyword + "&src=srp&pn=100";
        List<String> pics = DoGET.getPic(url);
        req.setAttribute("video", v);
        req.setAttribute("user", myService.getUserByID(v.getU_id()));
        req.setAttribute("pics", pics);
        req.getRequestDispatcher(Constants.DIR_HOME + "pic.jsp").forward(req, res);


    }

    //选择图片
    @RequestMapping(value = "/v/{v_id}/add-pic/", method = RequestMethod.POST)
    private void addPicAction(@PathVariable("v_id") int v_id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        String pic = req.getParameter("pic");

        Video v = myService.getVideo(v_id);
        System.out.println(v.toJSON());
        User u = myService.getUserByID(v.getU_id());
        req.setAttribute("chosen_pic", pic);
        req.setAttribute("user", u);
        req.setAttribute("video", v);
        List<Resource> resources = myService.getRes(v_id);
        req.setAttribute("res", resources);
        req.getRequestDispatcher(Constants.DIR_HOME + "video.jsp").forward(req, res);


    }

    //生成素材
    @RequestMapping(value = "/v/{v_id}/add-res", method = RequestMethod.POST)
    private void addRes(@PathVariable("v_id") int v_id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        String pic = req.getParameter("chosen_pic");
        String subtitle = req.getParameter("subtitle").replace("\r\n", "<br>");
        Video v = myService.getVideo(v_id);
        User u = myService.getUserByID(v.getU_id());
        List<Resource> resources = myService.getRes(v_id);
        req.setAttribute("res", resources);
        int d = Integer.parseInt(req.getParameter("duration"));
        System.out.println("subtitle:"+subtitle + "\nchosen_pic:"+pic+"\nd:"+d);
        if (d<=0){
            req.setAttribute("error","应大约0s");
            req.setAttribute("user", u);
            req.setAttribute("video", v);


            req.getRequestDispatcher(Constants.DIR_HOME + "video.jsp").forward(req, res);

        }else {
            int sum = 0 ;
            for (Resource r :resources){
                sum+=r.getDuration();
            }
            if(sum+d>300){
                req.setAttribute("error","大于300s了");
                req.setAttribute("user", u);
                req.setAttribute("video", v);


                req.getRequestDispatcher(Constants.DIR_HOME + "video.jsp").forward(req, res);

            }else {
                myService.addRes(v_id, pic, subtitle, d);
                resources = myService.getRes(v_id);
                req.setAttribute("res", resources);
                req.setAttribute("user", u);
                req.setAttribute("video", v);


                req.getRequestDispatcher(Constants.DIR_HOME + "video.jsp").forward(req, res);
            }
        }






    }

    //生成素材
    @RequestMapping(value = "/v/{v_id}/add-bgm", method = RequestMethod.GET)
    private void addBgm(@PathVariable("v_id") int v_id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        Video v = myService.getVideo(v_id);
        User u = myService.getUserByID(v.getU_id());
        req.setAttribute("user", u);
        req.setAttribute("video", v);
        List<Resource> resources = myService.getRes(v_id);
        req.setAttribute("res", resources);
        req.getRequestDispatcher(Constants.DIR_HOME + "music.jsp").forward(req, res);


    }

    //生成素材
    @RequestMapping(value = "/v/{v_id}/add-music", method = RequestMethod.POST)
    private void addMusic(@PathVariable("v_id") int v_id, HttpServletRequest req, HttpServletResponse res, @RequestParam(value = "music", required = false) MultipartFile attachs) throws Exception {


        //获取源文件名
        String oldName = attachs.getOriginalFilename();
        //音乐文件名 id-time
        String bgm_name = v_id  + ".mp3";
        String size = "1280x720";
        //创建新的文件，用于接收用户上传的文件流
        File targetFile = new File(Constants.path, bgm_name);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        } else {
            targetFile.delete();
        }
        //将上传的文件保存
        try {
            //音乐文件保存成功
            attachs.transferTo(targetFile);
            System.out.println("bgm saved");
            //开始制作视频
            //下载图片并编辑台词
            List<Resource> resources = myService.getRes(v_id);
            String input_txt = "";
            String subtitle_txt = Constants.subtitle_head;
            int start = 0;
            for (Resource r : resources) {
                String imgUrl = r.getPic_url();
                int d = r.getDuration();

                String subtitle = r.getSubtitle().replace("<br>", "\\N");



                subtitle_txt += "\nDialogue: 2,0:"+(start/60)+":"+(start%60)+".00,0:"+((start+d)/60)+":"+((start+d)%60)+".00,Default,,0,0,0,,"+subtitle;
                start+=d;

                System.out.println("subtile:" + subtitle);
                //图片url中的前面部分：例如"http://images.csdn.net/"
                String beforeUrl = imgUrl.substring(0, imgUrl.lastIndexOf("/") + 1);
                //图片url中的后面部分：例如“20150529/PP6A7429_副本1.jpg”
                String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
                //编码之后的fileName，空格会变成字符"+"
                String newFileName = URLEncoder.encode(fileName, "UTF-8");
                //把编码之后的fileName中的字符"+"，替换为UTF-8中的空格表示："%20"
                newFileName = newFileName.replaceAll("\\+", "\\%20");
                //编码之后的url
                imgUrl = beforeUrl + newFileName;
                //创建文件目录
                File files = new File(Constants.path, v_id + "-" + r.getR_id() + ".jpg");
                //获取下载地址
                URL url = new URL(imgUrl);
                //链接网络地址
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //获取链接的输出流
                InputStream is = connection.getInputStream();
                //创建文件，fileName为编码之前的文件名
//                File file = new File(dest_file);
                //根据输入流写入文件
                FileOutputStream out = new FileOutputStream(files);
                int i = 0;
                while ((i = is.read()) != -1) {
                    out.write(i);
                }
                out.close();
                is.close();
                String file_loc = "file '"+v_id + "-" + r.getR_id() + ".jpg'";
                String file_d = "duration "+d;
                input_txt+=file_loc+"\n"+file_d+"\n";

            }
            {


                writetoFile(Constants.path+"/"+v_id+"-input.txt",input_txt);
                System.out.println("input.txt");
                writetoFile(Constants.path+"/"+v_id+"-sub.ass",subtitle_txt);
                System.out.println("subtitle");

            }








        } catch (Exception e) {
            e.printStackTrace();
            return;

        }

        res.sendRedirect("/download/" +v_id);

    }

    private void writetoFile(String s, String input_txt) {
        FileWriter writer;
        try {
            writer = new FileWriter(s);
            writer.write(input_txt);
            writer.flush();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }


    //生成素材
    @RequestMapping(value = "/download/{v_id}", method = RequestMethod.GET)
    private void getVideo(@PathVariable("v_id") int v_id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        Video v = myService.getVideo(v_id);
        User u = myService.getUserByID(v.getU_id());
        req.setAttribute("user", u);
        req.setAttribute("video", v);
        List<Resource> resources = myService.getRes(v_id);
        req.setAttribute("res", resources);
        req.getRequestDispatcher(Constants.DIR_HOME + "download.jsp").forward(req, res);


    }
    //生成素材
    @RequestMapping(value = "/del-res/{r_id}", method = RequestMethod.GET)
    private void delRes(@PathVariable("r_id") int r_id, HttpServletRequest req, HttpServletResponse res) throws Exception {


        Resource r  = myService.getARes(r_id);
        myService.delRes(r_id);
        res.sendRedirect("/v/"+r.getV_id());


    }
    @RequestMapping(value = "/download/{v_id}", method = RequestMethod.POST)
    private void downVideo(@PathVariable("v_id") int v_id,HttpServletRequest req, HttpServletResponse res) throws Exception {


        Video v = myService.getVideo(v_id);
        User u = myService.getUserByID(v.getU_id());
        int style = Integer.parseInt(req.getParameter("style")); //1:phone 2:pc
        int qxd  = Integer.parseInt(req.getParameter("qxd")); //1：超清 2：高清 3. 标清
        String []sizes =  new String[]{"1280x720","720x480","480x360"};
        req.setAttribute("user", u);
        req.setAttribute("video", v);
        List<Resource> resources = myService.getRes(v_id);
        String fileName = "res/";



        //制作视频
        //-f concat -safe 0
        int sum=0;
        for (Resource r : resources) {
            sum+=r.getDuration();
        }
        List<String> command = new ArrayList<String>();
        command.add(Constants.ffmpeg);
        command.add("-f");
        command.add("concat");
        command.add("-safe");
        command.add("0");
        command.add("-i");
        command.add(Constants.path + "/" + v_id + "-input.txt");
        command.add("-i");
        command.add(Constants.path + "/" + v_id+".mp3");
        command.add("-t");
        command.add(""+sum);
        command.add("-s");
        command.add(sizes[qxd-1]);
        command.add(Constants.path + "/" + v_id + "null.mp4");
        command.add("-y");
        exc_cmd(command);
        System.out.println("已经生成视频");
        //添加台词
        List<String> command2 = new ArrayList<String>();
        command2.add(Constants.ffmpeg);
        command2.add("-y");
        command2.add("-i");
        command2.add(Constants.path + "/" + v_id + "null.mp4");
        command2.add("-vf");
        command2.add("subtitles="+Constants.path + "/" + v_id +"-sub.ass");
        command2.add(Constants.path + "/" + v_id + "pc.mp4");
        exc_cmd(command2);
        System.out.println("已经添加台词");

        String filename="res/"+v_id+"pc.mp4";
        if(style==1){
            String []size = sizes[qxd-1].split("x");
            //转9：16
            List<String> command3 = new ArrayList<String>();
            command3.add(Constants.ffmpeg);
            command3.add("-i");
            command3.add(Constants.path + "/" + v_id + "pc.mp4");
            command3.add("-y");
            command3.add("-lavfi");
            String p_tran = "[0:v]scale="+size[0]+"/"+size[1]+"*iw:"+size[0]+"/"+size[1]+"*ih,boxblur=luma_radius=min(h\\,w)/40:luma_power=3:chroma_radius=min(cw\\,ch)/40:chroma_power=1[bg];[bg][0:v]overlay=(W-w)/2:(H-h)/2,setsar=1,crop=w=iw*"+size[1]+"/"+size[0];
            command3.add(p_tran);
            command3.add(Constants.path + "/" + v_id + "phone.mp4");
            exc_cmd(command3);
            System.out.println("转换成手机版了");
            myService.finishVideo(v_id);
            fileName="res/"+v_id+"phone.mp4";
            filename = fileName;
        }else {
            fileName = "res/"+v_id+"pc.mp4";
            filename = fileName;
        }





        try {
            filename = URLEncoder.encode(filename,"UTF-8");
            res.addHeader("Content-Disposition", "attachment;filename=" + filename);
            res.setContentType("multipart/form-data");

            FileInputStream in = new FileInputStream(fileName);
            OutputStream out = res.getOutputStream();
            int len ;
            byte [] bytes = new byte[1024];
            while((len = in.read(bytes)) > 0){
                out.write(bytes,0,len);
            }
            in.close();
            out.close();
            System.out.println("已经下载完成了");
        }catch (Exception e){
            e.printStackTrace();
        }





    }

    //删除素材
    public static void exc_cmd(List<String> command) {
        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            Process process = null;
            try {
                process = builder.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            InputStream errorStream = process.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
            BufferedReader br = new BufferedReader(inputStreamReader);

            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            if (br != null) {
                br.close();
            }
            if (inputStreamReader != null) {

                inputStreamReader.close();
            }
            if (errorStream != null) {
                errorStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

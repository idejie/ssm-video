package com.grey.ssm.video.web;

import com.grey.ssm.video.DoGET;
import com.grey.ssm.video.model.Resource;
import com.grey.ssm.video.model.User;
import com.grey.ssm.video.model.Video;
import com.grey.ssm.video.service.MyService;
import com.grey.ssm.video.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        getPic("枸杞");
        if (user == null) {
            req.getRequestDispatcher(Constants.DIR_HOME + "login.jsp").forward(req, res);
        } else {
            res.sendRedirect("/history/" + user.getU_id());
        }

    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private void login(HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();

        req.setAttribute("error", session.getAttribute("error"));
        session.removeAttribute("error");
//        System.out.println("#######sssss");
        req.getRequestDispatcher(Constants.DIR_HOME + "login.jsp").forward(req, res);


    }

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

    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    private void manageAction(HttpServletRequest req, HttpServletResponse res) throws Exception {


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
//        for (Video v:
//                videos) {
//            System.out.println(v.toJSON());
//        }
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

//        session.removeAttribute("user");
//        req.getRequestDispatcher(Constants.DIR_HOME + "video.jsp").forward(req, res);


    }

    //视频更新

    //选择图片

    //生成素材


    //更新素材

    //删除素材


}

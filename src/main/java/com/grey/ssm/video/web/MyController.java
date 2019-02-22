package com.grey.ssm.video.web;

import com.grey.ssm.video.model.User;
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

@Controller
@RequestMapping("/")
public class MyController {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MyService myService;

    //首页
    @RequestMapping("/")
    private void index(HttpServletRequest req,HttpServletResponse res) throws Exception{
        req.getRequestDispatcher(Constants.DIR_HOME+"index.jsp");
    }
    //开始
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    private void start(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            req.getRequestDispatcher(Constants.DIR_HOME + "login.jsp").forward(req, res);
        }else {
            res.sendRedirect("/history");
        }

    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private void login(HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();

        req.setAttribute("error", session.getAttribute("error"));
        session.removeAttribute("error");
        System.out.println("#######sssss");
        req.getRequestDispatcher(Constants.DIR_HOME + "login.jsp").forward(req, res);



    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private void loginAction(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("###username:"+username+" ###password:"+password);
        HttpSession session = req.getSession();
        User user = myService.getUserByName(username);

        if(user==null){
            session.setAttribute("error", "无此用户");
            res.sendRedirect("/login");
        }else if(!user.getPassword().equals(password)){
            System.out.println(user.toJSON());
            session.setAttribute("error", "密码错误");
            res.sendRedirect("/login");
        }else {
            System.out.println(user.toJSON());
            session.setAttribute("user", user);
            res.sendRedirect("/history");
        }

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

        if(user!=null){
            System.out.println(user.toJSON());
            session.setAttribute("error", "已有此用户");
            res.sendRedirect("/sign");
        }else if(!password1.equals(password2)){
            session.setAttribute("error", "密码不一致");
            res.sendRedirect("/sign");
        }else {

            myService.addUser(username,password1);
            User newUser = myService.getUserByName(username);
            session.setAttribute("user", newUser);
            res.sendRedirect("/history");
        }

    }

    //登出


    //历史记录

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    private void history(HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();

        req.setAttribute("user", session.getAttribute("user"));
        session.removeAttribute("user");
        req.getRequestDispatcher(Constants.DIR_HOME + "history.jsp").forward(req, res);



    }
    //视频制作
    @RequestMapping(value = "/add-video", method = RequestMethod.GET)
    private void addVideo(HttpServletRequest req, HttpServletResponse res) throws Exception {


        HttpSession session = req.getSession();

        req.setAttribute("user", session.getAttribute("user"));
        session.removeAttribute("user");
        req.getRequestDispatcher(Constants.DIR_HOME + "video.jsp").forward(req, res);



    }
    //其他操作

    //视频删除

    //视频更新

    //选择图片

    //生成素材


    //更新素材

    //删除素材



//    @RequestMapping(value = "/stu/login", method = RequestMethod.GET)
//    private void stuLoginPage(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        HttpSession session = req.getSession();
//        req.setAttribute("error", session.getAttribute("error"));
//        session.removeAttribute("error");
//        req.getRequestDispatcher(Constants.DIR_STU + "login.jsp").forward(req, res);
//    }
//
//    @RequestMapping(value = "/stu/login", method = RequestMethod.POST)
//    private void stuLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        int stu_id = Integer.parseInt(req.getParameter("stu_id"));
//        String passwd = req.getParameter("passwd");
//        HttpSession session = req.getSession();
//        Student student = userService.queryStuByID(stu_id);
//        if (student != null) {
//            if (student.getPasswd().equals(passwd)) {
//                session.setAttribute("stu", student);
//                String re_url = (String) session.getAttribute("re_url");
//                if (re_url == null) {
//                    res.sendRedirect("/stu/profile/" + stu_id);
//                } else {
//                    session.removeAttribute("re_url");
//                    res.sendRedirect(re_url);
//                }
//            } else {
//                session.setAttribute("error", "密码错误");
//                res.sendRedirect("/stu/login");
//            }
//        } else {
//            session.setAttribute("error", "无此学生账号");
//            res.sendRedirect("/stu/login");
//        }
//    }
//
//
//    //学生注册
//    @RequestMapping(value = "/stu/register", method = RequestMethod.GET)
//    private void stuRegisterPage(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        HttpSession session = req.getSession();
//        req.setAttribute("error", session.getAttribute("error"));
//        session.removeAttribute("error");
//        req.getRequestDispatcher(Constants.DIR_STU + "register.jsp").forward(req, res);
//    }
//
//    @RequestMapping(value = "/stu/register", method = RequestMethod.POST)
//    private void stuRegister(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        int stu_id = Integer.parseInt(req.getParameter("stu_id"));
//        String stu_name = req.getParameter("stu_name");
//        String passwd = req.getParameter("passwd");
//        String grade = req.getParameter("grade");
//        int age = Integer.parseInt(req.getParameter("age"));
//        int qq = Integer.parseInt(req.getParameter("qq"));
//        String tele = req.getParameter("tele");
//        String email = req.getParameter("email");
//        String college = req.getParameter("college");
//        String subject = req.getParameter("subject");
//
//        HttpSession session = req.getSession();
//        Student havaStudent = userService.queryStuByID(stu_id);
//        Student student = new Student(stu_id, stu_name, passwd, grade, age, qq, tele, email, college, subject);
//        if (havaStudent == null) {
//            userService.insertStu(student);
//            session.setAttribute("stu", student);
//            String re_url = (String) session.getAttribute("re_url");
//            if (re_url != null) {
//                res.sendRedirect(re_url);
//            } else {
//                res.sendRedirect("/stu/profile/" + stu_id);
//            }
//        } else {
//            session.setAttribute("error", "此学生账号已注册，请联系管理员");
//            res.sendRedirect("/stu/register");
//        }
//    }
//
//    //学生资料
//    @RequestMapping(value = "/stu/profile/{stu_id}", method = RequestMethod.GET)
//    private void stuProfilePage(@PathVariable("stu_id")int stu_id, HttpServletRequest req, HttpServletResponse res) throws Exception {
//        HttpSession session = req.getSession();
//        Student student = userService.queryStuByID(stu_id);
//        req.setAttribute("stu_profile", student);
//       Student stu_login = (Student) session.getAttribute("stu");
//       if (student==null){
//            session.setAttribute("error", "无此学生");
//            res.sendRedirect("/error");
//       }else {
//           if (stu_login!=null&&stu_login.getId()==student.getId()){
//           req.setAttribute("isSameStu",true);
//            }else {
//           req.setAttribute("isSameStu",false);
//       }
//        req.getRequestDispatcher(Constants.DIR_STU + "profile.jsp").forward(req, res);
//       }
//
//    }
//
//    @RequestMapping(value = "/stu/profile/{stu_id}", method = RequestMethod.POST)
//    private void stuProfile(@PathVariable("stu_id")int stu_id, HttpServletRequest req, HttpServletResponse res) throws Exception {
//        String stu_name = req.getParameter("stu_name");
//        String passwd = req.getParameter("passwd");
//        String grade = req.getParameter("grade");
//        int age = Integer.parseInt(req.getParameter("age"));
//        int qq = Integer.parseInt(req.getParameter("qq"));
//        String tele = req.getParameter("tele");
//        String email = req.getParameter("email");
//        String college = req.getParameter("college");
//        String subject = req.getParameter("subject");
//
//        HttpSession session = req.getSession();
//       userService.updateStu(stu_id,stu_name,passwd,grade,age,qq,tele,email,college,subject);
//       session.setAttribute("success","更新成功");
//       res.sendRedirect("/success");
//
//    }
//
//    //学生退出
//    @RequestMapping("/stu/logout")
//    private void stuLogout(HttpServletRequest req,HttpServletResponse res)throws Exception{
//        HttpSession session = req.getSession();
//        session.removeAttribute("stu");
//        session.setAttribute("success","退出成功");
//        res.sendRedirect("/success");
//    }
//
//
//    //教师登录
//    @RequestMapping(value = "/teach/login", method = RequestMethod.GET)
//    private void teachLoginPage(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        HttpSession session = req.getSession();
//        session.setAttribute("re_url", session.getAttribute("re_url"));
//        req.getRequestDispatcher(Constants.DIR_TEACH + "login.jsp").forward(req, res);
//    }
//
//    @RequestMapping(value = "/teach/login", method = RequestMethod.POST)
//    private void teachLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        int t_id = Integer.parseInt(req.getParameter("t_id"));
//        String passwd = req.getParameter("passwd");
//        HttpSession session = req.getSession();
//        Teacher teacher = userService.queryTeachByID(t_id);
//        if (teacher != null) {
//            if (teacher.getPasswd().equals(passwd)) {
//                session.setAttribute("teacher", teacher);
//                String re_url = (String) session.getAttribute("re_url");
//                if (re_url == null) {
//                    res.sendRedirect("/teach/profile/" + t_id);
//                } else {
//                    session.removeAttribute("re_url");
//                    res.sendRedirect(re_url);
//                }
//            } else {
//                session.setAttribute("error", "密码错误");
//                res.sendRedirect("/teach/login");
//            }
//        } else {
//            session.setAttribute("error", "无此教师账号");
//            res.sendRedirect("/teach/login");
//        }
//    }
//
//    //教师注册
//    @RequestMapping(value = "/teach/register", method = RequestMethod.GET)
//    private void teachRegisterPage(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        HttpSession session = req.getSession();
//        req.setAttribute("error", session.getAttribute("error"));
//        session.removeAttribute("error");
//        req.getRequestDispatcher(Constants.DIR_STU + "register.jsp").forward(req, res);
//    }
//
//    @RequestMapping(value = "/teach/register", method = RequestMethod.POST)
//    private void teachRegister(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        int t_id = Integer.parseInt(req.getParameter("t_id"));
//        String t_name = req.getParameter("t_name");
//        String passwd = req.getParameter("passwd");
//        int qq = Integer.parseInt(req.getParameter("qq"));
//        String tele = req.getParameter("tele");
//        String email = req.getParameter("email");
//        String college = req.getParameter("college");
//        String subject = req.getParameter("subject");
//
//        HttpSession session = req.getSession();
//        Teacher havaTeacher = userService.queryTeachByID(t_id);
//        Teacher teacher = new Teacher(t_id, t_name, passwd, tele, qq, email, college, subject);
//        if (havaTeacher == null) {
//            userService.insertTeacher(teacher);
//            session.setAttribute("teacher", teacher);
//            String re_url = (String) session.getAttribute("re_url");
//            if (re_url != null) {
//                res.sendRedirect(re_url);
//            } else {
//                res.sendRedirect("/teach/profile/" + t_id);
//            }
//        } else {
//            session.setAttribute("error", "此教师账号已注册，请联系管理员");
//            res.sendRedirect("/teach/register");
//        }
//    }
//    //教师资料
//    @RequestMapping(value = "/teach/profile/{t_id}", method = RequestMethod.GET)
//    private void teachProfilePage(@PathVariable("t_id")int t_id, HttpServletRequest req, HttpServletResponse res) throws Exception {
//        HttpSession session = req.getSession();
//        Teacher teacher = userService.queryTeachByID(t_id);
//        req.setAttribute("teach_profile",teacher);
//        Teacher teach_login = (Teacher) session.getAttribute("teacher");
//       if (teacher==null){
//            session.setAttribute("error", "无此教师");
//            res.sendRedirect("/error");
//       }else {
//           if (teach_login!=null&&teach_login.getId()==teacher.getId()){
//           req.setAttribute("isSameTeach",true);
//            }else {
//           req.setAttribute("isSameTeach",false);
//       }
//        req.getRequestDispatcher(Constants.DIR_STU + "profile.jsp").forward(req, res);
//       }
//
//    }
//
//    @RequestMapping(value = "/teach/profile/{t_id}", method = RequestMethod.POST)
//    private void teachProfile(@PathVariable("t_id")int t_id, HttpServletRequest req, HttpServletResponse res) throws Exception {
//        String username = req.getParameter("username");
//        String passwd = req.getParameter("passwd");
//        int qq = Integer.parseInt(req.getParameter("qq"));
//        String tele = req.getParameter("tele");
//        String email = req.getParameter("email");
//        String college = req.getParameter("college");
//        String subject = req.getParameter("subject");
//
//        HttpSession session = req.getSession();
//        userService.updateTeach(t_id,username,passwd,qq,tele,email,college,subject);
//        session.setAttribute("success","更新成功");
//        res.sendRedirect("/success");
//    }
//    //教师退出
//    @RequestMapping("/teach/logout")
//    private void teachLogout(HttpServletRequest req,HttpServletResponse res)throws Exception{
//        HttpSession session = req.getSession();
//        session.removeAttribute("teach");
//        session.setAttribute("success","退出成功");
//        res.sendRedirect("/success");
//    }
//    //管理员登录
//    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
//    private void adminLoginPage(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        HttpSession session = req.getSession();
//        session.setAttribute("re_url", session.getAttribute("re_url"));
//        req.getRequestDispatcher(Constants.DIR_ADMIN + "login.jsp").forward(req, res);
//    }
//
//    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
//    private void adminLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        int admin_id = Integer.parseInt(req.getParameter("admin_id"));
//        String passwd = req.getParameter("passwd");
//        HttpSession session = req.getSession();
//        Admin admin = null;
//        if (admin != null) {
//            if (admin.getPasswd().equals(passwd)) {
//                session.setAttribute("admin", admin);
//                String re_url = (String) session.getAttribute("re_url");
//                if (re_url == null) {
//                    res.sendRedirect("/admin/manage/");
//                } else {
//                    session.removeAttribute("re_url");
//                    res.sendRedirect(re_url);
//                }
//            } else {
//                session.setAttribute("error", "密码错误");
//                res.sendRedirect("/admin/login");
//            }
//        } else {
//            session.setAttribute("error", "无此管理账号");
//            res.sendRedirect("/admin/login");
//        }
//    }
//    //管理员退出
//    @RequestMapping("/admin/logout")
//    private void adminLogout(HttpServletRequest req,HttpServletResponse res)throws Exception{
//        HttpSession session = req.getSession();
//        session.removeAttribute("admin");
//        session.setAttribute("success","退出成功");
//        res.sendRedirect("/success");
//    }
}

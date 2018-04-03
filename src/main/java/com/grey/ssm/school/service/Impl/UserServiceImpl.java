package com.grey.ssm.school.service.Impl;

import com.grey.ssm.school.dao.AdminDao;
import com.grey.ssm.school.dao.StudentDao;
import com.grey.ssm.school.dao.TeacherDao;
import com.grey.ssm.school.model.Admin;
import com.grey.ssm.school.model.Student;
import com.grey.ssm.school.model.Teacher;
import com.grey.ssm.school.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentDao stuDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private AdminDao adminDao;

    public Student queryStuByID(int stu_id) {
        return  stuDao.queryByID(stu_id);
    }

    public Teacher queryTeachByID(int t_id) {
        return teacherDao.queryByID(t_id);
    }

    public void insertStu(Student student) {
        stuDao.insert(student.getId(), student.getStu_name(), student.getPasswd(), student.getGrade(), student.getAge(),
                student.getQq(), student.getTele(), student.getEmail(), student.getCollege(), student.getSubject());
    }

    public void insertTeacher(Teacher teacher) {
        teacherDao.insert(teacher.getId(), teacher.getUsername(), teacher.getPasswd(), teacher.getQq(), teacher.getTele(),
                teacher.getEmail(), teacher.getCollege(), teacher.getSubject());
    }

    public Admin queryAdminByID(int admin_id) {
        return  adminDao.queryByID(admin_id);
    }

    public void updateStu(int stu_id, String stu_name, String passwd, String grade, int age, int qq, String tele, String email, String college, String subject) {
        stuDao.updateStu(stu_id, stu_name, passwd, grade, age, qq, tele, email, college, subject);
    }

    public void updateTeach(int t_id, String username, String passwd, int qq, String tele, String email, String college, String subject) {
        teacherDao.updateTeach(t_id,username,passwd,qq,tele,email,college,subject);
    }
}

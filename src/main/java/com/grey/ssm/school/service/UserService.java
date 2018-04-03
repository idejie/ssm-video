package com.grey.ssm.school.service;

import com.grey.ssm.school.model.Admin;
import com.grey.ssm.school.model.Student;
import com.grey.ssm.school.model.Teacher;


public interface UserService {
    Student queryStuByID(int stu_id);

    Teacher queryTeachByID(int t_id);

    void insertStu(Student student);

    void insertTeacher(Teacher teacher);

    Admin queryAdminByID(int admin_id);

    void updateStu(int stu_id, String stu_name, String passwd, String grade, int age, int qq, String tele, String email, String college, String subject);

    void updateTeach(int t_id, String username, String passwd, int qq, String tele, String email, String college, String subject);
}

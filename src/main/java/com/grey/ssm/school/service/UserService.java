package com.grey.ssm.school.service;

import com.grey.ssm.school.model.Student;
import com.grey.ssm.school.model.Teacher;


public interface UserService {
    Student queryStuByID(int stu_id);

    Teacher queryTeachByID(int t_id);

    void insertStu(Student student);
}

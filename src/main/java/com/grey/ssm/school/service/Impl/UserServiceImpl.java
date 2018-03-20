package com.grey.ssm.school.service.Impl;

import com.grey.ssm.school.dao.StudentDao;
import com.grey.ssm.school.dao.TeacherDao;
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

    public Student queryStuByID(int stu_id) {
        return  stuDao.queryByID(stu_id);
    }

    public Teacher queryTeachByID(int t_id) {
        return null;
    }

    public void insertStu(Student student) {
        stuDao.insert(student.getId(), student.getStu_name(), student.getPasswd(), student.getGrade(), student.getAge(),
                student.getQq(), student.getTele(), student.getEmail(), student.getCollege(), student.getSubject());
    }
}

package com.grey.ssm.school.dao;

import com.grey.ssm.school.model.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    Student queryByID(@Param("ID") int id);

    void delete(@Param("ID") int id);

    void insert(@Param("ID") int id, @Param("stu_name") String stu_name, @Param("passwd") String passwd,
                @Param("grade") int grade, @Param("age") int age, @Param("qq") int qq,
                @Param("tele") String tele, @Param("email") String email, @Param("college") String college, @Param("subject") String subject);
}

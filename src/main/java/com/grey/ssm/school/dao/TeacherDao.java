package com.grey.ssm.school.dao;

import com.grey.ssm.school.model.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherDao {
    Teacher queryByID(@Param("ID") int t_id);

    void insert(@Param("ID") int id, @Param("username") String username,
                @Param("passwd") String passwd, @Param("qq") int qq,
                @Param("tele") String tele, @Param("email") String email,
                @Param("college") String college, @Param("subject") String subject);
}

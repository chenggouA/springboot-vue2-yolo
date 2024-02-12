package com.haut.course.mapper;

import com.haut.course.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface studentMapper {

    /*
        查询某个课程的学生信息
     */
    @Select("select * from haut_student where student_id in (select StudentID from haut_student_courses where CourseID = #{id})")
    @Results({
            @Result(column = "class", property = "studentClass"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "photo_url", property = "photoUrl")
    })
    public List<Student> selectStudentInfoByClassId(@Param("id")int classId);


}

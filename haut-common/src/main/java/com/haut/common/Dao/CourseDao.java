package com.haut.common.Dao;

import com.haut.common.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseDao {


    @Select("select Name, CourseName, StartTime, EndTime, Status\n" +
            "from haut_courses left join haut_teacher ht on haut_courses.TeacherID = ht.TeacherID;\n")
    List<Map<String, Object>> getAllInfo();


    /*
        根据教师id, 和学生课程 查询记录
     */
    @Select("select * from haut_courses where CourseID = #{courseId}")
    Course selectByCourseId(int courseId);
}

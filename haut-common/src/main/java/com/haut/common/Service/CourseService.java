package com.haut.common.Service;

import com.haut.common.domain.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    /*
        获取所有的课程信息, 以及授课教师的姓名
     */
    List<Map<String, Object>> getAllInfo();

    /*
        根据id 获取课程信息
     */
    Course getCourseInfoById(int courseId);



}

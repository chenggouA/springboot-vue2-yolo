package com.haut.common.Service.Impl;

import com.haut.common.Dao.CourseDao;
import com.haut.common.Service.CourseService;
import com.haut.common.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;
    @Override
    public List<Map<String, Object>> getAllInfo() {
        return courseDao.getAllInfo();
    }

    @Override
    public Course getCourseInfoById(int courseId) {
        return courseDao.selectByCourseId(courseId);
    }
}

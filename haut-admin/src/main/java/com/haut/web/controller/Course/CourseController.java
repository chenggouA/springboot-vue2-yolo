package com.haut.web.controller.Course;

import com.haut.common.Service.CourseService;
import com.haut.common.core.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/all")
    AjaxResult getAll(){
        return AjaxResult.success("查询成功", courseService.getAllInfo());
    }

}

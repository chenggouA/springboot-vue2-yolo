package com.haut.web.controller.Attendance;

import com.haut.attendance.Service.AttendanceService;
import com.haut.common.Service.CourseService;
import com.haut.common.Service.Impl.CourseServiceImpl;
import com.haut.common.constant.HttpStatus;
import com.haut.common.core.AjaxResult;
import com.haut.common.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/attendance")
public class signInController {

    @Autowired
    CourseService courseService;

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    SimpleDateFormat formatter;


    /*
        TODO: 身份验证，必须是任课老师才能发布该课程的签到
        # 签到成功, 返回的是id
     */
    @RequestMapping("/publish")
    AjaxResult publish(
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @RequestParam("courseId") int courseId
    ){
        Course courseInfo = courseService.getCourseInfoById(courseId);

        if(courseInfo == null){
            return AjaxResult.error("课程不存在");
        }
        if(!Objects.equals(courseInfo.getStatus(), "正在进行中")){
            return AjaxResult.error(courseInfo.getStatus());
        }

        Object signRecordId = attendanceService.releaseSignIn(courseId, end);
        Map<String, Object> mp = new HashMap<>();
        mp.put("signRecordId", signRecordId);
        return AjaxResult.success("发布成功", mp);
    }

}

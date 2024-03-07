package com.haut.attendance.Service.Impl;


import com.haut.attendance.Service.AttendanceService;
import com.haut.attendance.dao.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceMapper attendanceMapper;

    @Autowired
    private SimpleDateFormat formatter;

    @Override
    public BigInteger releaseSignIn(int courseId, Date start) {
        Map<String, Object> mp = new HashMap<>();
        mp.put("courseID", courseId);
        mp.put("endTime", formatter.format(start));

        if(!attendanceMapper.insert(mp)){
            return BigInteger.valueOf(0);
        }
        return (BigInteger)mp.get("id");
    }
}

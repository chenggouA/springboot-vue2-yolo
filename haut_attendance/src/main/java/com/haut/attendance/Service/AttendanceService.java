package com.haut.attendance.Service;

import java.math.BigInteger;
import java.util.Date;

public interface AttendanceService {
    /*
        教师发布一条记录
     */
    BigInteger releaseSignIn(int courseId, Date start);
}

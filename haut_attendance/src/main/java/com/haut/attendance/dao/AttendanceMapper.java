package com.haut.attendance.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.Map;

@Mapper
public interface AttendanceMapper {

    /*
        插入一条签到记录
     */
    @Insert("insert into haut_sign (courseID, signEndTime) values (#{courseID},  #{endTime})")
    @Options(useGeneratedKeys = true, keyColumn = "signID", keyProperty = "id")
    boolean insert(Map<String, Object> params);
}

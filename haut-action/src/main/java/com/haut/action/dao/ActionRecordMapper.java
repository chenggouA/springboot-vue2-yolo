package com.haut.action.dao;

import com.haut.action.domain.ActionCoordinates;
import com.haut.action.domain.Behavior;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ActionRecordMapper {



    /*
        获取所有的行为类别

     */
    @Results(id = "BehaviorMap", value = {
            @Result(property = "id", column = "action_id", id = true),
            @Result(property = "isNegative", column = "is_negative"),
            @Result(property = "behaviorName", column = "action_name")
    })
    @Select("select * from haut_behavior")
    List<Behavior> getBehaviorType();


    /*
        获取指定时间范围的行为记录
     */
    @Results(id = "CoordinatesMap", value = { // 替换为你的实际实体类名
            @Result(column = "id", property = "id", id = true),
            @Result(column = "action_record_id", property = "actionRecordId"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "behavior_id", property = "behaviorId"),
            @Result(column = "x1", property = "x1"),
            @Result(column = "y1", property = "y1"),
            @Result(column = "x2", property = "x2"),
            @Result(column = "y2", property = "y2")
    })
    @Select("select * from haut_coordinates where id in (SELECT id FROM haut_action_record WHERE timestamp BETWEEN #{startTime} and #{endTime})")
    List<ActionCoordinates> getActionCoordinates(@Param("startTime") String startTime, @Param("endTime")String endTime);

}

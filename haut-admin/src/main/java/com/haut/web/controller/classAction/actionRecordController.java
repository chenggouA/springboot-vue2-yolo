package com.haut.web.controller.classAction;


import com.haut.action.Service.BehaviorStatisticsService;
import com.haut.action.Service.BehaviorTypeService;
import com.haut.action.Service.Impl.BehaviorStatisticsServiceImpl;
import com.haut.action.Service.Impl.BehaviorTypeServiceImpl;
import com.haut.action.domain.Behavior;
import com.haut.common.constant.HttpStatus;
import com.haut.common.core.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/action/record")
public class actionRecordController {

    @Autowired
    BehaviorTypeService behaviorTypeService;

    @Autowired
    BehaviorStatisticsService behaviorStatisticsService;

    /*
        根据起止时间获得行为次数
     */
    @RequestMapping("/time-range")
    AjaxResult getRecord(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end){

        if(start.compareTo(end) >= 0){
            return AjaxResult.error();
        }

        Map<Integer, Integer> behaviorCountInRange = behaviorStatisticsService.getBehaviorCountInRange(start, end);

        return new AjaxResult(HttpStatus.SUCCESS, "操作成功", behaviorCountInRange);

    }

    /*
        获取所有的行为类别
     */
    @RequestMapping("/type")
    AjaxResult getActionType(){
        List<Behavior> behaviors = behaviorTypeService.getAll();
        return new AjaxResult(HttpStatus.SUCCESS, "查询成功", behaviors);
    }


}

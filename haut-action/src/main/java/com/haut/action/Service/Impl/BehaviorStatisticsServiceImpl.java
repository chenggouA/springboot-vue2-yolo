package com.haut.action.Service.Impl;

import com.haut.action.Service.BehaviorStatisticsService;

import com.haut.action.Service.BehaviorTypeService;
import com.haut.action.dao.ActionRecordMapper;
import com.haut.action.domain.ActionCoordinates;

import com.haut.action.domain.Behavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BehaviorStatisticsServiceImpl implements BehaviorStatisticsService {

    @Autowired
    ActionRecordMapper actionRecordMapper;

    @Autowired
    SimpleDateFormat formatter;
    @Override
    public Map<Integer, Integer> getBehaviorCountInRange(Date start, Date end){

        String s = formatter.format(start);
        String e = formatter.format(end);

        List<Behavior> behaviorType = actionRecordMapper.getBehaviorType();
        Map<Integer, Integer> mp = new HashMap<>();

        for(Behavior b: behaviorType)
            mp.put(b.getId(), 0);

        List<ActionCoordinates> actionCoordinates = actionRecordMapper.getActionCoordinates(s, e);


        for(ActionCoordinates coordinate: actionCoordinates){
            int actionId = coordinate.getBehaviorId();
            mp.put(actionId, mp.get(actionId) + 1);
        }

        return mp;
    }
}

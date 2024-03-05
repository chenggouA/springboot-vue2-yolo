package com.haut.action.Service.Impl;

import com.haut.action.Service.BehaviorStatisticsService;

import com.haut.action.dao.ActionRecordMapper;
import com.haut.action.domain.ActionCoordinates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BehaviorStatisticsServiceImpl implements BehaviorStatisticsService {

    @Autowired
    ActionRecordMapper actionRecordMapper;
    @Override
    public Map<Integer, Integer> getBehaviorCountInRange(Date start, Date end){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(start);
        String e = formatter.format(end);
        List<ActionCoordinates> actionCoordinates = actionRecordMapper.getActionCoordinates(s, e);
        Map<Integer, Integer> mp = new HashMap<>();

        for(ActionCoordinates coordinate: actionCoordinates){
            int actionId = coordinate.getActionRecordId();
            if(!mp.containsKey(actionId))
                mp.put(actionId, 0);
            mp.put(actionId, mp.get(actionId) + 1);
        }

        return mp;
    }
}

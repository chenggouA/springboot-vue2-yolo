package com.haut.action.Service;

import java.util.Date;
import java.util.Map;

public interface BehaviorStatisticsService {

    // 获取给定时间范围内的各种行为的累计次数
    Map<Integer, Integer> getBehaviorCountInRange(Date start, Date end);
}

package com.haut.action.Service.Impl;

import com.haut.action.Service.BehaviorTypeService;
import com.haut.action.dao.ActionRecordMapper;
import com.haut.action.domain.Behavior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BehaviorTypeServiceImpl implements BehaviorTypeService {

    @Autowired
    ActionRecordMapper actionRecordMapper;
    @Override
    public List<Behavior> getAll() {
        return actionRecordMapper.getBehaviorType();
    }
}

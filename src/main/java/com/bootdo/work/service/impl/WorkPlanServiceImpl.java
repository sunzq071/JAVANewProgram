package com.bootdo.work.service.impl;

import com.bootdo.system.domain.RoleDO;
import com.bootdo.work.dao.WorkPlanDao;
import com.bootdo.work.domain.WorkPlanDO;
import com.bootdo.work.service.WorkPlanService;
import org.activiti.bpmn.converter.IndentingXMLStreamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * description:
 * Created By: TomSun
 * Date: 2018/9/17 16:11
 */
@Service
public class WorkPlanServiceImpl implements WorkPlanService {

    @Autowired
    private WorkPlanDao workPlanMapper;

    @Override
    public WorkPlanDO getPlanByIndx(Long indx) {
        WorkPlanDO workPlanDO = null;
        if(null== indx||indx==0L) {
            workPlanDO = new WorkPlanDO();
            workPlanDO.setIndx(0L);
        }else {
            workPlanDO = workPlanMapper.getPlanByIndx(indx);
        }
        return workPlanDO;
    }

    @Override
    public List<WorkPlanDO> list() {
        List<WorkPlanDO> workPlans = workPlanMapper.list(new HashMap<>(16));
        return workPlans;
    }

    @Override
    public int count(Map<String, Object> map) {
        return workPlanMapper.count(new HashMap<>(16));
    }

    @Override
    public int save(WorkPlanDO workPlan) {
        return workPlanMapper.save(workPlan);
    }

    @Override
    public int update(WorkPlanDO workPlan) {
        return workPlanMapper.update(workPlan);
    }

    @Override
    public int remove(Long Indx) {
        return workPlanMapper.remove(Indx);
    }
}

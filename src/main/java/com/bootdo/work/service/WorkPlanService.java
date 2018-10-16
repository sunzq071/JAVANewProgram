package com.bootdo.work.service;

import com.bootdo.system.domain.RoleDO;
import com.bootdo.work.domain.WorkPlanDO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description:
 * Created By: TomSun
 * Date: 2018/9/17 16:09
 */
@Service
public interface WorkPlanService {
    WorkPlanDO getPlanByIndx(Long Indx);

    List<WorkPlanDO> list();

    int count(Map<String,Object> map);

    int save(WorkPlanDO workPlan);

    int update(WorkPlanDO workPlan);

    int remove(Long Indx);
}

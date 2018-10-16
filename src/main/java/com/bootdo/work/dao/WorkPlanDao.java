package com.bootdo.work.dao;


import com.bootdo.system.domain.RoleDO;
import com.bootdo.work.domain.WorkPlanDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 工作计划
 * description:
 * Created By: TomSun
 * Date: 2018/9/17 16:04
 */
@Mapper
public interface WorkPlanDao {

    WorkPlanDO getPlanByIndx(Long indx);

    List<WorkPlanDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(WorkPlanDO workPlan);

    int update(WorkPlanDO workPlan);

    int remove(Long indx);
}

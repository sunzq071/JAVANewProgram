package com.bootdo.work.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.work.domain.WorkPlanDO;
import com.bootdo.work.service.WorkPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description:
 * Created By: TomSun
 * Date: 2018/9/17 15:51
 */
@RequestMapping("/work/plan")
@Controller
public class PlanController extends BaseController{
    String prefix = "work/plan";
    @Autowired
    WorkPlanService workPlanService;

    @RequiresPermissions("work:plan:plan")
    @GetMapping()
    String plan() {
        return prefix + "/plan";
    }

    @RequiresPermissions("work:plan:plan")
    @GetMapping("/list")
    @ResponseBody()
    List<WorkPlanDO> list() {
        List<WorkPlanDO> plans = workPlanService.list();
        return plans;
    }

    @Log("添加工作计划")
    @RequiresPermissions("work:plan:add")
    @GetMapping("/add/{id}")
    String add(Model model,@PathVariable("id") Long indx) {
        WorkPlanDO workPlanDO = workPlanService.getPlanByIndx(indx);
        model.addAttribute("plan", workPlanDO);
        return prefix + "/add";
    }


    @Log("保存工作计划")
    @RequiresPermissions("work:plan:add")
    @PostMapping("/save")
    @ResponseBody()
    R save(WorkPlanDO workPlan) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//        }
        if(null==workPlan.getIndx()||workPlan.getIndx()==0L)
        {
            if (workPlanService.save(workPlan) > 0)
            {
                return R.ok();
            } else {
                return R.error(1, "保存失败");
            }
        }
        else
        {
            if (workPlanService.update(workPlan) > 0)
            {
                return R.ok();
            } else {
                return R.error(1, "保存失败");
            }
        }
    }

    @Log("删除工作计划")
    @RequiresPermissions("work:plan:remove")
    @PostMapping("/remove")
    @ResponseBody()
    R remove(Long id){
        if (workPlanService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }
}

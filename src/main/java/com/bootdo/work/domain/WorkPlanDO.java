package com.bootdo.work.domain;

import java.sql.Timestamp;

/**
 * 工作计划
 *
 * description:
 * Created By: TomSun
 * Date: 2018/9/17 15:43
 */
public class WorkPlanDO{
    private Long indx;
    private String workTask;
    private String productName;
    private String developer;
    private Timestamp preStartTime;
    private Timestamp preFinishTime;
    private String remark;

    public Long getIndx() {
        return indx;
    }

    public void setIndx(Long indx) {
        this.indx = indx;
    }

    public String getWorkTask() {
        return workTask;
    }

    public void setWorkTask(String workTask) {
        this.workTask = workTask;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Timestamp getPreStartTime() {
        return preStartTime;
    }

    public void setPreStartTime(Timestamp preStartTime) {
        this.preStartTime = preStartTime;
    }

    public Timestamp getPreFinishTime() {
        return preFinishTime;
    }

    public void setPreFinishTime(Timestamp preFinishTime) {
        this.preFinishTime = preFinishTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WorkPlanDO{" +
                "indx=" + indx +
                ", workTask='" + workTask + '\'' +
                ", productName='" + productName + '\'' +
                ", developer='" + developer + '\'' +
                ", preStartTime=" + preStartTime +
                ", preFinishTime=" + preFinishTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}

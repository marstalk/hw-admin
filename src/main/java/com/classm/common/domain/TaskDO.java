package com.classm.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @email
 * @date 2017-09-25 15:09:21
 */
public class TaskDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    // cron表达式
    private String cronExpression;
    // 任务调用的方法名
    private String methodName;
    // 任务是否有Status
    private String isConcurrent;
    // 任务描述
    private String description;
    // 更新者
    private String updateBy;
    // 任务执行时调用哪个类的方法 包名+类名
    private String beanClass;
    // 创建时间
    private Date createDate;
    // 任务Status
    private String jobStatus;
    // 任务分组
    private String jobGroup;
    // 更新时间
    private Date updateDate;
    // 创建者
    private String createBy;
    // Spring bean
    private String springBean;
    // 任务名
    private String jobName;

    /**
     *  Set:
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get: ：
     */
    public Long getId() {
        return id;
    }

    /**
     *  Set: cron表达式
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * Get: ：cron表达式
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     *  Set: 任务调用的方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Get: ：任务调用的方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     *  Set: 任务是否有Status
     */
    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * Get: ：任务是否有Status
     */
    public String getIsConcurrent() {
        return isConcurrent;
    }

    /**
     *  Set: 任务描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get: ：任务描述
     */
    public String getDescription() {
        return description;
    }

    /**
     *  Set: 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * Get: ：更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     *  Set: 任务执行时调用哪个类的方法 包名+类名
     */
    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * Get: ：任务执行时调用哪个类的方法 包名+类名
     */
    public String getBeanClass() {
        return beanClass;
    }

    /**
     *  Set: 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get: ：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  Set: 任务Status
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * Get: ：任务Status
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     *  Set: 任务分组
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * Get: ：任务分组
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     *  Set: 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Get: ：更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  Set: 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * Get: ：创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     *  Set: Spring bean
     */
    public void setSpringBean(String springBean) {
        this.springBean = springBean;
    }

    /**
     * Get: ：Spring bean
     */
    public String getSpringBean() {
        return springBean;
    }

    /**
     *  Set: 任务名
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Get: ：任务名
     */
    public String getJobName() {
        return jobName;
    }

    @Override
    public String toString() {
        return "TaskDO{" +
                "id=" + id +
                ", cronExpression='" + cronExpression + '\'' +
                ", methodName='" + methodName + '\'' +
                ", isConcurrent='" + isConcurrent + '\'' +
                ", description='" + description + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", beanClass='" + beanClass + '\'' +
                ", createDate=" + createDate +
                ", jobStatus='" + jobStatus + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", updateDate=" + updateDate +
                ", createBy='" + createBy + '\'' +
                ", springBean='" + springBean + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}

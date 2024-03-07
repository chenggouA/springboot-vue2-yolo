package com.haut.attendance.domain;

import java.util.Date;

public class Sign {
    private int signID;
    private Integer courseID;
    private Date createTime;
    private Date signEndTime;

    /*
        0 - 已过期
        1 - 未过期
     */
    private Boolean status;

    @Override
    public String toString() {
        return "Sign{" +
                "signID=" + signID +
                ", courseID=" + courseID +
                ", createTime=" + createTime +
                ", signEndTime=" + signEndTime +
                ", status=" + status +
                '}';
    }

    public int getSignID() {
        return signID;
    }

    public void setSignID(int signID) {
        this.signID = signID;
    }


    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(Date signEndTime) {
        this.signEndTime = signEndTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

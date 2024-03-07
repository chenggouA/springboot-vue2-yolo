package com.haut.attendance.domain;

import java.util.Date;

public class SignRecord {
    private int recordId;
    private Integer signId;
    private Integer studentId;
    private Date signTime;

    @Override
    public String toString() {
        return "SignRecord{" +
                "recordId=" + recordId +
                ", signId=" + signId +
                ", studentId=" + studentId +
                ", signTime=" + signTime +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }
}

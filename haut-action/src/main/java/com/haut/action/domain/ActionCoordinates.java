package com.haut.action.domain;


public class ActionCoordinates { // 请替换为你的实体类名

    private Integer id;
    private Integer actionRecordId;
    private Integer studentId;
    private Integer behaviorId;
    private Integer x1;
    private Integer y1;
    private Integer x2;
    private Integer y2;

    @Override
    public String toString() {
        return "ActionCoordinates{" +
                "id=" + id +
                ", actionRecordId=" + actionRecordId +
                ", studentId=" + studentId +
                ", behaviorId=" + behaviorId +
                ", x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActionRecordId() {
        return actionRecordId;
    }

    public void setActionRecordId(Integer actionRecordId) {
        this.actionRecordId = actionRecordId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(Integer behaviorId) {
        this.behaviorId = behaviorId;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }
}
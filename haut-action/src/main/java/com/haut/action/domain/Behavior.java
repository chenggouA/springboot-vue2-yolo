package com.haut.action.domain;

public class Behavior {

    private Integer id;

    private boolean isNegative;

    private  String behaviorName;

    @Override
    public String toString() {
        return "Behavior{" +
                "id=" + id +
                ", isNegative=" + isNegative +
                ", behaviorName='" + behaviorName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNegative() {
        return isNegative;
    }

    public void setNegative(boolean negative) {
        isNegative = negative;
    }

    public String getBehaviorName() {
        return behaviorName;
    }

    public void setBehaviorName(String behaviorName) {
        this.behaviorName = behaviorName;
    }
}

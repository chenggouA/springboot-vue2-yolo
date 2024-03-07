package com.haut.common.domain;

import java.util.Date;

public class Course {

    private int CourseID;
    private String CourseName;
    private int TeacherID;
    private Date StartTime;
    private Date EndTime;
    private String Status;

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseID=" + CourseID +
                ", CourseName='" + CourseName + '\'' +
                ", TeacherID=" + TeacherID +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", Status='" + Status + '\'' +
                '}';
    }
}

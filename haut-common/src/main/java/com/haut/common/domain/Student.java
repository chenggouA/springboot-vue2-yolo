package com.haut.common.domain;

public class Student {
    int student_id;
    String class_;
    int grade;
    String name;
    String photo_url;

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", class_='" + class_ + '\'' +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", photo_url='" + photo_url + '\'' +
                '}';
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
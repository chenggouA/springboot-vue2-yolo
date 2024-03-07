package com.haut.common.domain;

public class Teacher {
    int TeacherID;
    String Name;
    String Gender;
    String Email;
    String PhoneNumber;

    @Override
    public String toString() {
        return "Teacher{" +
                "TeacherID=" + TeacherID +
                ", Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
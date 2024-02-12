package com.haut;

import com.haut.course.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.haut.course.mapper.studentMapper;

import java.util.List;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    studentMapper studentmapper;
    @Test
    public void Test(){
        List<Student> students = studentmapper.selectStudentInfoByClassId(1);
        System.out.println(students);
    }
}

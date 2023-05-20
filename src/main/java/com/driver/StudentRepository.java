package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> students = new HashMap<>(); // for Storing students data

    public void add(Student student) {
        students.put(student.getName(), student);
    }

    public Student findByName(String name) {
        return students.get(name);
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(students.keySet());
    }
}

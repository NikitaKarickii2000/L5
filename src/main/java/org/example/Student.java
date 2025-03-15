package org.example;

import java.util.List;

public class Student {
    public String name;
    private String group;
    public int _class;
    private List<Integer> grade;

    public Student(String name, String group, int _class, List<Integer> grade) {
        this.name = name;
        this.group = group;
        this._class = _class;
        this.grade = grade;
    }
    public double calculateGrade() {
        if (grade.isEmpty()) return 0.0;
        int sum = 0;
        for (int i = 0; i < grade.size(); i++) {
            sum += grade.get(i);
        }
        return (double) sum / grade.size();
    }
    public int getCourse() {
        return _class;
    }


    public String getName() {
        return name;
    }

}

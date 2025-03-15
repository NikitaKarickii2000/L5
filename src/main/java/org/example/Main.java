package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        List<Integer> grade1 = new ArrayList<>();
        grade1.add(3);
        grade1.add(2);
        grade1.add(1);
        students.add(new Student("Никита", "Группа 1", 1, grade1));

        List<Integer> grade2 = new ArrayList<>();
        grade2.add(4);
        grade2.add(5);
        grade2.add(6);
        students.add(new Student("Виктор", "Группа 2", 1, grade2));
        removeBadStudents(students);
        promoteGoodStudents(students);
        printStudentsByCourse(students, 2);
    }
    static void removeBadStudents(List <Student> students) {

        int i = 0;
        while (i < students.size()) {
            Student s = students.get(i);
            if (s.calculateGrade() < 3.0) {
                students.remove(i);
            } else {
                i++;
            }
        }
    }
            static void promoteGoodStudents (List <Student> students) {
                for (Student s : students) {
                    if (s.calculateGrade() >= 3.0) {
                        s._class += 1;
                    }
                }
            }
    static void printStudentsByCourse(List<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }






}
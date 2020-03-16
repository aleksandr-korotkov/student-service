package services;

import entities.Student;

import java.util.List;

public interface StudentService {

    boolean addStudent(Student student);

    double calcAverage(String firstName, String lastName);

    int calcTrainingHoursLeft(String firstName, String lastName);

    int calcTrainingDaysLeft(String firstName, String lastName);

    String optionExpulsion(String firstName, String lastName);

    void printStudentsSortedByAveragePoint();

    void printStudentsSortedByTrainingDaysLeft();

    List<Student> filterStudentListByOptionExpulsion();
}

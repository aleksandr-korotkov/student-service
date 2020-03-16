package entities;

import repositories.CourseRepository;
import repositories.MarksRepository;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private String curriculum;
    private LocalDate startTaskDate;
    private CourseRepository courseRepository;
    private MarksRepository marksRepository;

    public Student() {
    }

    public Student(String firstName, String lastName, String curriculum, LocalDate startTaskDate, CourseRepository courseRepository, MarksRepository marksRepository) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.curriculum = curriculum;
        this.startTaskDate = startTaskDate;
        this.courseRepository = courseRepository;
        this.marksRepository = marksRepository;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public MarksRepository getMarksRepository() {
        return marksRepository;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(curriculum, student.curriculum) &&
                Objects.equals(startTaskDate, student.startTaskDate) &&
                Objects.equals(courseRepository, student.courseRepository) &&
                Objects.equals(marksRepository, student.marksRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, curriculum, startTaskDate, courseRepository, marksRepository);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", curriculum='" + curriculum + '\'' +
                ", startTaskDate=" + startTaskDate +
                ", courseRepository=" + courseRepository +
                ", marksRepository=" + marksRepository +
                '}';
    }
}

package repositories;

import entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> getStudents();

    void addStudent(Student student);

    Optional<Student> findByFullName(String firstName, String lastName);
}

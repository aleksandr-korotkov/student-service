package repositories;

import entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository{

    private List<Student> students;

    public StudentRepositoryImpl() {
        students = new ArrayList<>();
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Optional<Student> findByFullName(String firstName, String lastName) {
        for (Student student : students){
            if(student.getFirstName().equals(firstName)&&student.getLastName().equals(lastName)){
                return Optional.ofNullable(student);
            }
        }
        return Optional.empty();
    }
}

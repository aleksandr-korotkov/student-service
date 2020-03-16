import entities.Course;
import entities.Student;
import repositories.*;
import services.StudentService;
import services.StudentServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        CourseRepository courseRepositoryIvanov = new CourseRepositoryImpl();
        courseRepositoryIvanov.addCourse(new Course("Технология Java Servlets", 16));
        courseRepositoryIvanov.addCourse(new Course("Struts Framework", 24));
        courseRepositoryIvanov.addCourse(new Course("Spring Framework", 48));
        courseRepositoryIvanov.addCourse(new Course("Hibernate", 20));
        MarksRepository marksRepositoryIvanov = new MarksRepositoryImpl();
        marksRepositoryIvanov.addMark(3);
        marksRepositoryIvanov.addMark(4);
        marksRepositoryIvanov.addMark(2);
        marksRepositoryIvanov.addMark(5);
        marksRepositoryIvanov.addMark(3);
        marksRepositoryIvanov.addMark(3);
        studentRepository.addStudent(new Student("Ivan", "Ivanov", "J2EE Developer", LocalDate.now(), courseRepositoryIvanov, marksRepositoryIvanov));

        CourseRepository courseRepositoryPetrov = new CourseRepositoryImpl();
        courseRepositoryPetrov.addCourse(new Course("Обзор технологий Java", 8));
        courseRepositoryPetrov.addCourse(new Course("Библиотека JFC/Swing", 16));
        courseRepositoryPetrov.addCourse(new Course("Технология JDBC", 16));
        courseRepositoryPetrov.addCourse(new Course(". Технология JAX", 52));
        courseRepositoryPetrov.addCourse(new Course(". Библиотеки commons", 44));
        MarksRepository marksRepositoryPetrov = new MarksRepositoryImpl();
        marksRepositoryPetrov.addMark(4);
        marksRepositoryPetrov.addMark(5);
        marksRepositoryPetrov.addMark(3);
        marksRepositoryPetrov.addMark(2);
        marksRepositoryPetrov.addMark(3);
        marksRepositoryPetrov.addMark(3);
        marksRepositoryPetrov.addMark(5);
        marksRepositoryPetrov.addMark(5);
        studentRepository.addStudent(new Student("Petr", "Petrov", "Java Developer", LocalDate.now(), courseRepositoryPetrov, marksRepositoryPetrov));

        StudentService studentService = new StudentServiceImpl(studentRepository);

        for(Student student : studentRepository.getStudents()){
            System.out.println(student.getLastName() + " " + student.getFirstName() + " - До окончания обучения по программе " + student.getCurriculum() +
                    " осталось " + studentService.calcTrainingHoursLeft(student.getFirstName(),student.getLastName()) + " часов. Средний балл " +
                    studentService.calcAverage(student.getFirstName(),student.getLastName())+ ". " + studentService.optionExpulsion(student.getFirstName(),student.getLastName()));
        }
    }
}

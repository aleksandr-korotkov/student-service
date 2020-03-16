package services;

import entities.Course;
import entities.Student;
import repositories.StudentRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentServiceImpl implements StudentService {
    final int HOURS_IN_STUDY_DAY = 8;
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean addStudent(Student student) {
        if(student != null){
            studentRepository.addStudent(student);
            return true;
        }
        return false;
    }

    @Override
    public double calcAverage(String firstName, String lastName) {
        double average = studentRepository.findByFullName(firstName, lastName).get().getMarksRepository().getMarks().stream()
                .mapToDouble(Integer::doubleValue).average().getAsDouble();
        return new BigDecimal(average).setScale(1,BigDecimal.ROUND_DOWN).doubleValue();
    }

    @Override
    public int calcTrainingHoursLeft(String firstName, String lastName) {
        Student student = studentRepository.findByFullName(firstName, lastName).get();
        int sumDurationOfCourses = student.getCourseRepository().getCourses().stream().mapToInt(Course::getDuration).sum();
        int trainingDaysPassed = student.getMarksRepository().getMarks().size();
        return sumDurationOfCourses - trainingDaysPassed * HOURS_IN_STUDY_DAY;
    }

    @Override
    public int calcTrainingDaysLeft(String firstName, String lastName) {
        int daysLeft = calcTrainingHoursLeft(firstName, lastName);
        if(daysLeft%HOURS_IN_STUDY_DAY==0){
            return daysLeft/HOURS_IN_STUDY_DAY;
        }
        else return daysLeft/HOURS_IN_STUDY_DAY+1;
    }

    @Override
    public String optionExpulsion(String firstName, String lastName) {
        int daysLeft = calcTrainingDaysLeft(firstName, lastName);
        List<Integer> marks =  new ArrayList<>(studentRepository.findByFullName(firstName,lastName).get().getMarksRepository().getMarks());
        for (int i = 0; i < daysLeft; i++) {
            marks.add(5);
        }
        if(marks.stream().mapToDouble(Integer::doubleValue).sum()/marks.size()>4.4){
            return "Может продолжать обучение.";
        }
        return "Отчислить.";
    }

    @Override
    public void printStudentsSortedByAveragePoint() {
        Map<Student,Double> studentsWithAverage = new HashMap<>();
        List<Student> students = studentRepository.getStudents();
        for(Student student : students){
            studentsWithAverage.put(student,calcAverage(student.getFirstName(),student.getLastName()));
        }
        studentsWithAverage.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                forEach((k)-> System.out.println("Студент " + k.getKey().getFirstName() + " " + k.getKey().getLastName() + ". Средний балл = " + k.getValue()));
    }

    @Override
    public void printStudentsSortedByTrainingDaysLeft() {
        Map<Student,Integer> studentsWithTrainingHoursLeft = new HashMap<>();
        List<Student> students = studentRepository.getStudents();
        for(Student student : students){
            studentsWithTrainingHoursLeft.put(student, calcTrainingHoursLeft(student.getFirstName(),student.getLastName()));
        }
        studentsWithTrainingHoursLeft.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                forEach((k)-> System.out.println("Студент " + k.getKey().getFirstName() + " " + k.getKey().getLastName() + ". Осталось часов = " + k.getValue()));
    }

    @Override
    public List<Student> filterStudentListByOptionExpulsion() {
        List<Student> filterStudents = new ArrayList<>();
        for (Student student : studentRepository.getStudents()){
            if(optionExpulsion(student.getFirstName(),student.getLastName()).equals("Может продолжать обучение.")){
                filterStudents.add(student);
            }
        }
        return filterStudents;
    }
}

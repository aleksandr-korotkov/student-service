package repositories;

import entities.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> getCourses();

    void addCourse(Course course);
}

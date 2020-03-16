package repositories;

import entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository{

    private List<Course> courses;

    public CourseRepositoryImpl() {
        courses = new ArrayList<>();
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "CourseRepositoryImpl{" +
                "courseList=" + courses +
                '}';
    }
}

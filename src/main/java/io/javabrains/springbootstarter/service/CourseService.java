package io.javabrains.springbootstarter.service;

import io.javabrains.springbootstarter.exceptions.NotFoundException;
import io.javabrains.springbootstarter.model.Course;
import io.javabrains.springbootstarter.repository.CourseRepository;
import io.javabrains.springbootstarter.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicService topicService;


    public List<Course> getAllCourses(String id) {
        return new ArrayList<>(courseRepository.findByTopicId(id));
    }

    public Course getCourseById(String id){
        return courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Unable to find the course"));
    }

    public void addCourse(Course course, String topicId) {
        //if (!topicService.getTopicById(topicId)) throw new NotFoundException("")
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) throws NotFoundException {
        course.setId(id);
        course.setTopic(getCourseById(id).getTopic());
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}

package io.javabrains.springbootstarter;

import io.javabrains.springbootstarter.model.Course;
import io.javabrains.springbootstarter.model.Topic;
import io.javabrains.springbootstarter.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/{topicId}/courses/{id}")
    public Course getCourseById(@PathVariable String id){
        return courseService.getCourseById(id);
    }


    @PostMapping(value = "/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        courseService.addCourse(course, topicId);
    }

    @PutMapping(value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.updateCourse(course, id);
    }

    @DeleteMapping(value = "/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}

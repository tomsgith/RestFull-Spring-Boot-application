package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
public List<Course> getAllCourses(String topicId){
	List<Course> allCourses=new ArrayList<>();
	 courseRepository
	 .findByTopicId(topicId)
	 .forEach(allCourses::add);
    return allCourses;
}
public Course getCourse(String id) {
	return courseRepository.findById(id).get();
}
public void add(Course course) {
	courseRepository.save(course);
	
}
public void update(Course course) {
	courseRepository.save(course);	
}
public void deleteTopic(String id) {
	courseRepository.deleteById(id);
	
	
}
}

package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	@RequestMapping("topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	@RequestMapping("topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.add(course);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		courseService.update(course);
	}
	@RequestMapping(value="/topics/{topicId}/courses/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		 courseService.deleteTopic(id);
	}
}

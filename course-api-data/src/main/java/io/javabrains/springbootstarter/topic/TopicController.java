package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	@RequestMapping("topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic top) {
		topicService.add(top);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void editTopic(@RequestBody Topic top,@PathVariable String id) {
		topicService.update(id,top);
	}
	@RequestMapping(value="topics/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}
}

package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
public List<Topic> getAllTopics(){
	List<Topic> allTopics=new ArrayList<>();
	 topicRepository.findAll()
	 .forEach(allTopics::add);
    return allTopics;
}
public Topic getTopic(String id) {
	return topicRepository.findById(id).get();
}
public void add(Topic top) {
	topicRepository.save(top);
	
}
public void update(String id,Topic top) {
	topicRepository.save(top);	
}
public void deleteTopic(String id) {
	topicRepository.deleteById(id);
	
	
}
}

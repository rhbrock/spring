package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	//dependency injection
	@Autowired
	private TopicService topicService;

//	@RequestMapping("/topics")
//	public String getAllTopics() {
//		return "All Topics";
//	}
	
	//moved to Service
//	@RequestMapping("/topics")
//	public List<Topic> getAllTopics() {
//		return Arrays.asList(
//				new Topic("spring", "Spring Framework", "Spring Framework Description"),
//				new Topic("java", "Core Java", "Core Java Description"),
//				new Topic("javascript", "JaveScript", "JavaScript Description")
//				);
//		
//		//Spring MVC converts objects to JSON
//	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	//@PathVariable send the path variable to the method variable "id"
	//If path var name is different than method var, then @PathVariable("x") String id
	//Name path and method var the same is a good standard
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//@RequestBody converts JSON to an object (Topic) instance
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}

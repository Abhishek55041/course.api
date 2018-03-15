package course.api.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "Spring name", "Description"),
			new Topic("Java", "Core Java", " Java Description"),
			new Topic("Maven", "Maven name", "Maven Description")));

	public List<Topic> getAllTopics() {

		return topics;
	}

	public Topic getTopic(String id) {

		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {

		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {

		for (int i = 0; i < topics.size(); i++) {

			if (topics.get(i).getId() == id) {
				topics.set(i, topic);
				return;
			}
		}

	}
	
	public void deleteTopic(String id) {

		topics.removeIf(t->t.getId().equals(id));
		
	}

}

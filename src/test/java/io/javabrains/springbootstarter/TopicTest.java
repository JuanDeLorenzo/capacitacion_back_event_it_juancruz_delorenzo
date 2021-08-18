package io.javabrains.springbootstarter;

import io.javabrains.springbootstarter.model.Topic;
import io.javabrains.springbootstarter.service.TopicService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicService topicService;

    public TopicTest(){}

    @Test
    public void test001_createTopicAndCheckPersistInDB(){
        Topic topic = new Topic("Topic1", "Topic1 Description");
        topicService.addTopic(topic);

        assertTrue(topicService.getTopicById(topic.getId()).isPresent());

    }

}

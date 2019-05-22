package com.szu.springboot.test;

import com.szu.springboot.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
	@Autowired
	private TopicSender topicSender;

	@Test
	public void topic1() throws  Exception{
		topicSender.send1();
	}
	@Test
	public void topic2() throws  Exception{
		topicSender.send2();
	}
	@Test
	public void topic3() throws  Exception{
		topicSender.send3();
	}


}
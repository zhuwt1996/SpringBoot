package com.szu.springboot.test;



import com.szu.springboot.many.MySender1;
import com.szu.springboot.many.MySender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
	@Autowired
	private MySender1 mySender1;

	@Autowired
	private MySender2 mySender2;

	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			mySender1.send(i);
		}
	}

	@Test
	public void manyToMany() throws Exception {
		for (int i=0;i<100;i++){
			mySender1.send(i);
			mySender2.send(i);
		}
	}

}
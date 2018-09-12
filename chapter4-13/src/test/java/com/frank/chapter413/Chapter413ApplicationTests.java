package com.frank.chapter413;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter413ApplicationTests {
	@ClassRule
	public static OutputCapture out = new OutputCapture();

	@Test
	public void test_001(){
		String output = out.toString();
	}

}

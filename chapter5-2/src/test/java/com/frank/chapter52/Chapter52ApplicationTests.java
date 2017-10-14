package com.frank.chapter52;

import com.frank.chapter52.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter52ApplicationTests {

	@Autowired
	private Task task;

	@Test
	public void test_001() throws InterruptedException {
		long start = System.currentTimeMillis();
		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskSecond();
		Future<String> task3 = task.doTaskThird();

		while (true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环
				break;
			}
			Thread.sleep(1000);
		}
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时： " + (end - start) + "毫秒");


	}

}

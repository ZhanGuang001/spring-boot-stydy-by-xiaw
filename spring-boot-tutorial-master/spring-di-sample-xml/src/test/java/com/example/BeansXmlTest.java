package com.example;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.bean.AwareBean;
import com.example.bean.LifeBean;
import com.example.service.HelloWorldService;

public class BeansXmlTest {
	private AbstractApplicationContext context;

	public BeansXmlTest() {
		context = new ClassPathXmlApplicationContext("beans.xml");
//		context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		context.registerShutdownHook();
		System.out.println("ApplicationContext hashCode:"+context.hashCode());
	}

	@Test
	public void testHelloService() {
		HelloWorldService service = context.getBean("helloService", HelloWorldService.class);
		service.sayHello();
	}

	@Test
	public void testLifeBean() {
		LifeBean lifeBean = context.getBean("lifeBean", LifeBean.class);
	}

	@Test
	public void testAwareBean() {
		AwareBean awareBean = context.getBean("awareBean", AwareBean.class);
		System.out.println(awareBean.getApplicationContext());
		System.out.println(awareBean.getApplicationContext().hashCode());
	}
}

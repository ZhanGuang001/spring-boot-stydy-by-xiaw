package com.example;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.bean.XmlBean;
import com.example.service.HelloWorldService;

public class ApplicationContextTest {
	
	private AbstractApplicationContext context;
	
	public ApplicationContextTest() {
		//容器初始化
		context = new FileSystemXmlApplicationContext("classpath:/META-INF/application-context.xml");
//		context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
		context.registerShutdownHook();		
	}

	@Test
	public void testApplicationTest() {
		//取得实例
		HelloWorldService helloWorldService =context.getBean("helloWorldService",HelloWorldService.class);
		//使用实例
		helloWorldService.sayHello();	
	}
	
	@Test
	public void testXmlBean() {
		XmlBean xmlBean = context.getBean("xmlBean",XmlBean.class);
		System.out.println(xmlBean.getP1()+","+xmlBean.getP2());
	}

}

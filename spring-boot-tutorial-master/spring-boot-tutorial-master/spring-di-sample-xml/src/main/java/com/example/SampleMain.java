package com.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.bean.ExampleBean;
import com.example.bean.XmlBean;
import com.example.service.HelloWorldService;

public class SampleMain {
	public static void main(String[] args) {	
		//容器初始化
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/application-context.xml");
		int count = context.getBeanDefinitionCount();		
		System.out.println("Beans的个数：" + count);
		
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.print(name+"--->");
			Object bean = context.getBean(name);
			System.out.println(bean.getClass());
		}
		context.getBean("helloWorldService",HelloWorldService.class).sayHello();
		System.out.println(context.getBean("exampleBean",ExampleBean.class).getBeanOne().getName());
		System.out.println(context.getBean("exampleBean",ExampleBean.class).getBeanTwo().getName());
		System.out.println(context.getBean("xmlBean",XmlBean.class).getP2());
	}
}

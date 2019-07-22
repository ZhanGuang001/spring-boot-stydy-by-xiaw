package com.example;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

import com.example.bean.AnotherBean;
import com.example.bean.ExampleBean;
import com.example.bean.YetAnotherBean;
import com.example.service.HelloWorldService;

@Configuration
//@ComponentScan(basePackages="com.example")
//@Import({ConfigA.class,ConfigB.class})
@ImportResource("classpath:/META-INF/application-context.xml")
public class SampleConfig {
	
	@Bean
	public HelloWorldService HelloWorldService() {
		return new HelloWorldService();
	}
		
	@Bean
	public ExampleBean exampleBean() {
		ExampleBean exampleBean = new ExampleBean();
		exampleBean.setBeanOne(anotherBean());
		exampleBean.setBeanTwo(yetAnotherBean());
		return exampleBean;
	}
	
	@Bean("aaa")
	@Primary  //如果有多个的话，使用这个
	public AnotherBean anotherBean() {
		AnotherBean anotherBean = new AnotherBean();
		anotherBean.setName("i'm anotherBean.");
		return anotherBean;
	}
	
	@Bean
	public YetAnotherBean yetAnotherBean() {
		YetAnotherBean yetAnotherBean = new YetAnotherBean();
		yetAnotherBean.setName("i'm yetAnoterBean.");
		return yetAnotherBean;
	}
	
	@Bean(destroyMethod = "close")
	DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("12345678");
		ds.setUrl("jdbc:mysql://localhost:3306/tdf?useUnicode=true&characterEncoding=utf-8");
		return ds;
	}
	
}

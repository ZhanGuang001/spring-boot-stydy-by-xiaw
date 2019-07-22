package com.example.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
/**
 * 实现bean的初始化和销毁的方式
 * 1.配置init-method,destroy-method
 * 2.implements InitializingBean,DisposableBean
 * 3.注解@PostConstruct、@PreDestroy
 */
public class LifeBean implements InitializingBean,DisposableBean{

	public void start() {
		System.out.println("start LifeBean");
	}
	
	public void stop() {
        // do some destruction work (like releasing pooled connections)
		System.out.println("stop LifeBean");
    }
	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init lifebean");
		
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy lifebean");
		
	}
}

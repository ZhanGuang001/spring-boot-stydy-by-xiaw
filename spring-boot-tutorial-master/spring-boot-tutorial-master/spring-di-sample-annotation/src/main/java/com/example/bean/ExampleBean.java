package com.example.bean;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype")
public class ExampleBean {
	@Autowired
//	@Qualifier("aaa")
	private AnotherBean beanOne;

	@Autowired
	private YetAnotherBean beanTwo;

	private int i=1;

	public ExampleBean() {
		
	}

	public ExampleBean(AnotherBean beanOne, YetAnotherBean beanTwo, int i) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
		this.i = i;
	}
	
	@Autowired
	public void setBeanOne(AnotherBean beanOne) {
		this.beanOne = beanOne;
	}
	
	@Autowired
	public void setBeanTwo(YetAnotherBean beanTwo) {
		this.beanTwo = beanTwo;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public AnotherBean getBeanOne() {
		return beanOne;
	}

	public YetAnotherBean getBeanTwo() {
		return beanTwo;
	}

}

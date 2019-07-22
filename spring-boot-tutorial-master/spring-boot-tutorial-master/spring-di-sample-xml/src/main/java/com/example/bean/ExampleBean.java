package com.example.bean;

public class ExampleBean {
	private AnotherBean beanOne;

	private YetAnotherBean beanTwo;

	private int i;

	public ExampleBean() {
		
	}

	public ExampleBean(AnotherBean beanOne, YetAnotherBean beanTwo, int i) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
		this.i = i;
	}
	
	public void setBeanOne(AnotherBean beanOne) {
		this.beanOne = beanOne;
	}
	
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

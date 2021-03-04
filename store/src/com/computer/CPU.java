package com.computer;

public class CPU extends Part{
	
	
	int speed;
	public CPU(int speed , String name) {
		super(name);
		this.speed= speed;
		
	} 
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public int getSpeed() {
		return this.speed;
	}
	
	@Override 
	public void print() {
		System.out.println("**************************");
		super.print();
		System.out.println("Speed : "+this.speed+" GHz");
		System.out.println("**************************");
	}

}

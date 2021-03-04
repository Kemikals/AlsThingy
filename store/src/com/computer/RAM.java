package com.computer;

public class RAM extends Part{

	int size;
	public RAM(int size,String name) {
		super(name);
		this.size=size;
		
	}
	
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public void print() {
		System.out.println("**************************");
		super.print();
		System.out.println("Size : "+this.size+" GB");
		System.out.println("**************************");
		
	}
	
	

}

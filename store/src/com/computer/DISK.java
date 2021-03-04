package com.computer;

public class DISK extends Part{

	String type;
	int capacity;
	public DISK(int capacity,String type , String name) {
		super(name);
		this.type=type;
		this.capacity=capacity;
	}
	
	
	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getType() {
			
		return this.type;
	}
	
	@Override
	public void print () {
		System.out.println("**************************");
		super.print();
		System.out.println("Type : "+this.type +"\nDISK Capacity : "+ this.capacity+" GB" );
		System.out.println("**************************");
	}

}

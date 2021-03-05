package com.parts;

import com.helpers.Build;
import com.helpers.Part;

public class Disk extends Part implements Build{

	
	private String capacity;
	public final static String DISK_INSTALL = "->>INSTALLING SYSTEM DISK.....DONE\n";
	public Disk(String capacity, String name) {
		super(name);
		
		this.capacity=capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	
	@Override
	public void print () {
		System.out.println("**************************");
		super.print();
		System.out.println("DISK Capacity : "+ this.capacity);
		System.out.println("**************************");
	}

	@Override
	public String install() {
		if(MISSING()) {
			this.capacity = "NOT_SELECTED";
			return (">>NO DISK SELECTED/FOUND...BUILD WITHOUT DISK UNIT..\n");
			
		}
		return (DISK_INSTALL);
		
	}

	@Override
	public boolean MISSING() {
		
		return (this.capacity.equalsIgnoreCase("0 GB")||this.capacity.equalsIgnoreCase("NOT_SELECTED"));
	}

}

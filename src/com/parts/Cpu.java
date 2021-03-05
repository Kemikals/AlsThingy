package com.parts;

import com.helpers.Build;
import com.helpers.Part;

public class Cpu extends Part implements Build{
	
	
	private String speed;
	public static final String CPU_INSTALL = "->>INSTALLING SYSTEM CPU .....DONE\n"; 
	
	public Cpu(String speed , String name) 
	{
		super(name);
		this.speed= speed;
		
	} 
	public void setSpeed(String speed) {
		this.speed=speed;
	}

	@Override 
	public void print() {
		System.out.println("**************************");
		super.print();
		System.out.println("Speed : "+this.speed);
		System.out.println("**************************");
	}
	@Override
	public String install() {
		if(MISSING()) 
		{	this.speed = "NOT_SELECTED";
			return (">>NO CPU SELECTED/FOUND...BUILD WITHOUT CPU UNIT..\n");
		}
		return (CPU_INSTALL);
		
	}
	@Override
	public boolean MISSING() {
		return (this.speed.equalsIgnoreCase("NOT_SELECTED")||this.speed.equalsIgnoreCase("0 GHZ"));
	}

}

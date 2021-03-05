package com.helpers;

public class Part {

	private final String name;
	public static final String OS_INSTALL = "->>INSTALLING OPERATING SYSTEM .....DONE\n";
	
	public Part(String name) 
	{
		this.name= name;
	}


	public void print()
	{
		
		System.out.println(this.name);
		
	}
	
	
	
}

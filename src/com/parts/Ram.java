package com.parts;

import com.helpers.Build;
import com.helpers.Part;

public class Ram extends Part implements Build{

	private  String  size;
	public static final String RAM_INSTALL = "->>INSTALLING SYSTEM RAM .....DONE\n";
	
	public Ram(String size,String name) 
	{
		super(name);
		this.size=size;
		
	}


	public void setSize(String size)
	{
		this.size = size;
	}


	@Override
	public void print() {
		System.out.println("**************************");
		super.print();
		System.out.println("Size : "+this.size);
		System.out.println("**************************");
		
	}

	@Override
	public String install() {
		if(MISSING()) 
		{
			this.size = "NOT_SELECTED";
			return (">>NO RAM SELECTED/FOUND...BUILD WITHOUT RAM UNIT..\n");
			
		}
		return (RAM_INSTALL);
		
	}

	@Override
	public boolean MISSING()
	{
		
		return (this.size.equalsIgnoreCase("0 GB")||this.size.equalsIgnoreCase("NOT_SELECTED"));
		 
	}
	
	

}

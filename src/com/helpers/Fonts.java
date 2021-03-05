package com.helpers;

import java.awt.Font;

@SuppressWarnings("SpellCheckingInspection")
public class Fonts {
	
		
	public static Font Plain_Size(int size) 
	{
		return new Font("Tahoma", Font.PLAIN, size);
		
	}
	
	public static Font Bold_Size(int size) 
	{
		return new Font("Tahoma", Font.BOLD, size);
		
	}
	
	public static Font ItalicBold_Size(int size) 
	{
		return new Font("Tahoma", Font.BOLD | Font.ITALIC, size);
		
	}
	
	

}

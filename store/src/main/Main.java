package main;
import java.util.ArrayList;

import com.products.Computer;
import com.products.Product;
import com.products.TV;

public class Main {

	static Computer computer = new Computer();
	
	static ArrayList<Product> prodects = new ArrayList<>();
	
    public static void main(String[] args)
    {
           computer.setName("Gaming Computer");

           computer.setManufacture("DELL");

           computer.setOS("Windows");
           
           computer.cpu.setSpeed(5);
           
           computer.ram.setSize(128);
           
           computer.disk.setCapacity(500);
           
           computer.disk.setType("SSD ");

           Computer.computerParts.add(computer.ram);
           Computer.computerParts.add(computer.cpu);
           Computer.computerParts.add(computer.disk);
           
           
           //TV
           
           TV tv = new TV();
           
           tv.setManufacture("Samsung");
           
           tv.setName("4k TV");
           
           tv.setScreenSize(65);
           
           tv.setType("OLED");

           computer.print();
           for(int i=0;i<Computer.computerParts.size();i++) {
        	   
        	   Computer.computerParts.get(i).print();
           }
           System.out.println("\n");
           tv.print();
           for(int i=0;i<prodects.size();i++) {
        	   
        	 prodects.get(i).print();
           }



    }
}

package com.products;

import java.util.ArrayList;

import com.computer.CPU;
import com.computer.DISK;
import com.computer.Part;
import com.computer.RAM;

public class Computer extends Product{

    String OS;
    public RAM ram = new RAM(0, "SYSTEM RAM");
    public CPU cpu = new CPU(0, "PROCESSORE");
    public DISK disk = new DISK(0, "type", "STORAGE");
    public static ArrayList<Part> computerParts = new ArrayList<Part>();
    
    public Computer(String name, String manufacture,String OS) {
        super(name, manufacture);
        this.OS=OS;
    }

    public Computer() {
        super();
    }


    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

   
    @Override
    public void print() {
        super.print();
        System.out.println("nOS :" + OS);
        System.out.println("**************************");

    }
}

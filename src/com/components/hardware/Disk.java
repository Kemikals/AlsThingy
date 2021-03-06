package com.components.hardware;

import com.components.Component;
import com.store.InstallMessage;
import com.components.Installable;

public class Disk extends Component implements Installable {

    private String capacity;


    public Disk(String capacity) {
        super("DISK");
        this.capacity = capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public void print() {
        System.out.println("**************************");
        super.print();
        System.out.println("DISK Capacity : " + this.capacity);
        System.out.println("**************************");
    }

    @Override
    public String toString() {
        return capacity;
    }
}

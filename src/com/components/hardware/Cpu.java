package com.components.hardware;

import com.components.Component;
import com.components.InstallMessage;
import com.components.Installable;

public class Cpu extends Component implements Installable {

    private String speed;

    public Cpu(String speed, String name) {
        super(name, InstallMessage.CPU);
        this.speed = speed;

    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public void print() {
        System.out.println("**************************");
        super.print();
        System.out.println("Speed : " + this.speed);
        System.out.println("**************************");
    }
}

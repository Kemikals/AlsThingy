package com.components.hardware;

import com.components.Component;
import com.components.InstallMessage;
import com.components.Installable;

public class Ram extends Component implements Installable {

    private String size;
    public static InstallMessage failureMessage = InstallMessage.RAM_FAILURE;

    public Ram(String size) {
        super("RAM");
        this.size = size;

    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void print() {
        System.out.println("**************************");
        super.print();
        System.out.println("Size : " + this.size);
        System.out.println("**************************");

    }

    @Override
    public String toString() {
        return size;
    }
}

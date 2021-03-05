package com.components;

public enum InstallMessage {

    OS("->>INSTALLING OPERATING SYSTEM.....DONE"),
    CPU("->>INSTALLING SYSTEM CPU .....DONE"),
    RAM("->>INSTALLING SYSTEM RAM .....DONE"),
    DISK("->>INSTALLING SYSTEM DISK.....DONE"),
    OS_FAILURE(">> OS CAN NOT BE INSTALLED .... MISSING COMPONENT(S)..");

    private final String message;

    InstallMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}

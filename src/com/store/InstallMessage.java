package com.store;

public enum InstallMessage {

    OS("->>INSTALLING OPERATING SYSTEM.....DONE"),
    CPU("->>INSTALLING SYSTEM CPU .....DONE"),
    RAM("->>INSTALLING SYSTEM RAM .....DONE"),
    DISK("->>INSTALLING SYSTEM DISK.....DONE"),
    CPU_FAILURE("->>INSTALLING SYSTEM CPU .....FAIL"),
    RAM_FAILURE("->>INSTALLING SYSTEM RAM .....FAIL"),
    DISK_FAILURE("->>INSTALLING SYSTEM DISK....._FAIL"),
    OS_FAILURE(">> OS CAN NOT BE INSTALLED .... MISSING COMPONENT(S)..");

    private final String message;

    InstallMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}

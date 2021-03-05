package com.components;

public class Component implements Installable {

    private final String name;
    private final InstallMessage installMessage;

    private boolean installed;

    public Component(String name, InstallMessage installMessage) {
        this.name = name;
        this.installMessage = installMessage;
    }

    public void print() {
        System.out.println(this.name);
    }

    @Override
    public Component install() {
        this.installed = true;
        return this;
    }

    @Override
    public boolean isInstalled() {
        return installed;
    }

    public InstallMessage getInstallMessage() {
        return installMessage;
    }
}

package com.components;

public abstract class Component implements Installable {

    private boolean installed;
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println(name);
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
}

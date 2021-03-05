package com.components;

public interface Installable {
    Component install(); // methods in interfaces are public and abstract by default

    boolean isInstalled();
}

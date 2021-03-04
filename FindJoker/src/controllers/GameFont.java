package controllers;

import java.awt.*;

public class GameFont {

    public static Font plainSize(int size){

        return new Font(Font.MONOSPACED, Font.PLAIN, size);
    }
    public static Font boldSize(int size){

        return new Font(Font.MONOSPACED, Font.BOLD, size);
    }

}

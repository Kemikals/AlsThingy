package controllers;

import controllers.ImageFile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class Dice extends JLabel {

    public Dice(int x,int y){
        Random roll = new Random();
        int faceRoll = roll.nextInt(6)+1;
        this.setBounds(x, y, 100, 100);
        this.setBorder(new EmptyBorder(0,0,0,0));

        this.setIcon(ImageFile.select("src/Files/dice/"+faceRoll+".png" ,100 ,100 ));

    }


    public void roll(int dice) {

        setBorder(new EmptyBorder(0,0,0,0));
        setIcon(ImageFile.select("src/Files/dice/"+dice+".png" ,100 ,100 ));
    }
}

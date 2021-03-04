package controllers;

import javax.swing.*;
import java.awt.*;

public class ImageFile extends ImageIcon {


    private static final int W = 160;
    private static final int H = 210;

    public static ImageIcon select(String file,int W , int H)
    {

        return new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));

    }

    public static ImageIcon Card(int num)
    {

        return new ImageIcon(new ImageIcon("src/Files/CardsImages/"+num+".png").getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));

    }

    public static ImageIcon cover()
    {

        return new ImageIcon(new ImageIcon("src/Files/CardsImages/cover.jpg").getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));

    }

}

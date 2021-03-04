package controllers;

import controllers.Card;
import controllers.ImageFile;

import javax.swing.border.EmptyBorder;

public class Joker extends Card {


    public Joker()
    {
      super();
      this.setIcon(ImageFile.Card(0));
      this.setDisabledIcon(ImageFile.Card(0));
      this.setCardID(0);

    }
}

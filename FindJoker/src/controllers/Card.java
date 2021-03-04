package controllers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class Card extends JButton{

    int cardID;

    public Card(){
        this.setFocusable(false);
        this.setBorder(new EmptyBorder(0,0,0,0));
    }

    public Card(ActionListener cardListener){
        this.addActionListener(cardListener);
        this.setEnabled(true);
    }

    public void markedSelected()
    {
        this.setEnabled(false);
    }

    public void setCardID(int cardID)
    {
        this.cardID = cardID;
    }

    public int getCardID()
    {
        return cardID;
    }

    public void setCardCover()
    {
     this.setIcon(ImageFile.cover());
     this.setDisabledIcon(ImageFile.cover());
     this.setBorder(new EmptyBorder(0,0,0,0));
     this.setFocusable(false);
    }
    public void setCardFace(int cardID)
    {
        this.setIcon(ImageFile.Card(cardID));
        this.setDisabledIcon(ImageFile.Card(cardID));
        this.setBorder(new EmptyBorder(0,0,0,0));
        this.setFocusable(false);
    }

    public boolean equals(Card other){

        return (this.cardID == other.cardID);
    }

}

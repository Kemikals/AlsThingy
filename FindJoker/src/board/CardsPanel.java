package board;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import controllers.Card;
import controllers.Joker;

public class CardsPanel extends Container {

    public final ArrayList<Integer> numbersList = new ArrayList<>();
    public final Card[] card = new Card[12];
    public final Card selectedCard = new Card();
    public final Joker jokerCard = new Joker();


    public CardsPanel(){

        setLayout(new GridLayout(3, 4));
        setSize(650,650);


        for (int cardNumber = 0;cardNumber<card.length;cardNumber++)
        {
            numbersList.add(cardNumber);

        }

        Collections.shuffle(numbersList);

        System.out.println(numbersList);

        }

}







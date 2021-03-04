package board;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import controllers.Card;
import controllers.GamePlay;

public class GameFrame extends JFrame implements ActionListener , GamePlay {

    final int CARDS_NUMBERS = 12;
    final CardsPanel cardsPanel = new CardsPanel();
    final ControllerPane controllerPane = new ControllerPane();
    final Container container = getContentPane();
    int counter =45;
    final Timer timer;
    public GameFrame(){
        setSize(665, 850);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        container.setBackground(Color.WHITE);
        setLayout(null);
        controllerPane.diceButton.setEnabled(false);
        controllerPane.left.setVisible(false);
        controllerPane.right.setVisible(false);
        controllerPane.diceButton.addActionListener(this);
        controllerPane.newGameButton.addActionListener(this);

        timer = new Timer(1000, (event) ->
        {
           controllerPane.timeLabel.setText(String.valueOf(counter));
           counter--;

        });


        for (int cardIndex = 0;cardIndex<CARDS_NUMBERS;cardIndex++)
        {
            cardsPanel.card[cardIndex] = new Card(this);
            cardsPanel.card[cardIndex].setCardCover();
            cardsPanel.card[cardIndex].setEnabled(false);
            cardsPanel.add(cardsPanel.card[cardIndex]);

        }

        container.add(cardsPanel);
        container.add(controllerPane);
        setContentPane(container);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int cardIndex = 0;cardIndex<CARDS_NUMBERS;cardIndex++)
        {
            cardsPanel.selectedCard.setCardID(cardsPanel.numbersList.get(cardIndex));


            if (e.getSource() == cardsPanel.card[cardIndex]){
                ControllerPane.moves--;
                controllerPane.movesView.setText(String.valueOf(ControllerPane.moves));
                cardsPanel.card[cardIndex].setCardFace(cardsPanel.selectedCard.getCardID());
                cardsPanel.card[cardIndex].markedSelected();



                if(cardsPanel.selectedCard.equals(cardsPanel.jokerCard))
                {
                    JOptionPane.showMessageDialog(null, "Winner");
                }
                if(ControllerPane.moves ==0 || counter == 0){

                    GAME_OVER();
                    cardsPanel.card[cardIndex].setEnabled(false);
                    cardsPanel.card[cardIndex].setCardCover();

                }

            }
            if(e.getSource()==controllerPane.diceButton)
            {
                cardsPanel.card[cardIndex].setEnabled(true);
                ROLL_DICE();
            }
            if(e.getSource()==controllerPane.newGameButton){
                cardsPanel.card[cardIndex].setCardCover();
                cardsPanel.card[cardIndex].setEnabled(false);
                controllerPane.diceButton.setEnabled(true);
                NEW_GAME();
            }
    }
}

    @Override
    public void GAME_OVER()
    {
    JOptionPane.showMessageDialog(this, "SORRY , BETTER LUCK NEXT TIME");
    counter = 45;
    ControllerPane.moves =0;
    timer.stop();


    }

    @Override
    public void NEW_GAME()
    {
        ControllerPane.moves =0;
        counter = 45;
        timer.stop();
        controllerPane.timeLabel.setText("");
        controllerPane.movesView.setText("");
        controllerPane.timeLabel.setVisible(false);
        controllerPane.movesView.setVisible(false);
        controllerPane.left.setVisible(false);
        controllerPane.right.setVisible(false);

    }

    @Override
    public void ROLL_DICE()
    {
        timer.start();
        controllerPane.timeLabel.setVisible(true);
        int diceOne = new Random().nextInt(6)+1;
        int diceTwo = new Random().nextInt(6)+1;
        ControllerPane.moves = diceOne+diceTwo;
        controllerPane.left.roll(diceOne);
        controllerPane.right.roll(diceTwo);
        controllerPane. left.setVisible(true);
        controllerPane.right.setVisible(true);
        controllerPane.movesView.setVisible(true);
        controllerPane. movesView.setText(String.valueOf(ControllerPane.moves));
        controllerPane.remove(controllerPane.left);
        controllerPane.remove(controllerPane.right);
        controllerPane.add(controllerPane.left);
        controllerPane.add(controllerPane.right);
        controllerPane.repaint();
        controllerPane.revalidate();
        controllerPane.diceButton.setEnabled(false);
        Collections.shuffle(cardsPanel.numbersList);
        controllerPane.diceButton.setEnabled(false);
    }
}

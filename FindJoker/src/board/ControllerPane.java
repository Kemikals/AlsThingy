package board;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controllers.Dice;
import controllers.GameFont;

public class ControllerPane extends Container
{

    public final JButton diceButton,newGameButton;
    public final JLabel movesLabel,movesView,timeLabel;
    public final Dice left = new Dice(225, 35);
    public final Dice right = new Dice(335, 35);
    public static int moves ;
    public ControllerPane(){

        setBackground(Color.WHITE);
        setBounds(0, 655, 659, 165);
        setLayout(null);

        diceButton = new JButton("ROLL THE DICE");
        diceButton.setFont(GameFont.boldSize(20));
        diceButton.setBounds(440, 100, 200, 50);
        add(diceButton);

        newGameButton = new JButton("NEW GAME");
        newGameButton.setFont(GameFont.boldSize(20));
        newGameButton.setBounds(10, 100, 200, 50);
        add(newGameButton);

        movesLabel = new JLabel("NUMBER OF MOVES");
        movesLabel.setFont(GameFont.boldSize(20));
        movesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        movesLabel.setBounds(10, 10, 200, 30);
        add(movesLabel);

        movesView = new JLabel("");
        movesView.setFont(GameFont.boldSize(20));
        movesView.setHorizontalAlignment(SwingConstants.CENTER);
        movesView.setBounds(40, 40, 100, 50);
        add(movesView);

        timeLabel = new JLabel("");
        timeLabel.setFont(GameFont.boldSize(50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setBounds(500, 22, 87, 67);
        add(left);
        add(right);
        add(timeLabel);


    }

}

